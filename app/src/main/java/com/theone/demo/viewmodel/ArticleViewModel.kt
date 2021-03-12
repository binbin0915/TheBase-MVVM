package com.theone.demo.viewmodel

import com.theone.demo.data.model.bean.ArticleResponse
import com.theone.demo.app.net.PagerResponse
import com.theone.demo.app.net.Url
import com.theone.demo.app.util.UserUtil
import com.theone.demo.data.model.bean.CollectBus
import com.theone.mvvm.base.ext.request
import com.theone.mvvm.base.ext.util.logE
import com.theone.mvvm.callback.livedata.StringLiveData
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse

abstract class ArticleViewModel(val url: String? = null) : BaseDemoViewModel<ArticleResponse>() {

    //收藏文章
    private val collectionError: StringLiveData = StringLiveData()

    fun getCollectionError(): StringLiveData = collectionError

    override fun requestServer() {
        request({
            val response = RxHttp.get(url, getPage())
                .setCacheMode(getCacheMode())
                .toResponse<PagerResponse<List<ArticleResponse>>>()
                .await()
            onSuccess(response)
        })
    }

    override fun onSuccess(response: List<ArticleResponse>?) {
        // 第一次是从缓存里获取，这里要拿用户里收藏的判断一下
        response?.run {
            if (isFirst.value) {
                val user = UserUtil.getUser()
                user?.collectIds?.forEach { id ->
                    for (index in this.indices) {
                        if(this[index].id == id.toInt()){
                            this[index].collect = true
                            break
                        }
                    }
                }
            }
        }
        super.onSuccess(response)
    }

    open fun collection(article: ArticleResponse, event: AppViewModel) {
        val url = if (article.collect) Url.UN_LIST_COLLECTION else Url.COLLECTION_ARTICLE
        request({
            RxHttp.postForm(url, article.getArticleId())
                .toResponse<String>()
                .await()
            event.collectEvent.value = CollectBus(article.getArticleId(), !article.collect)
        }, null, collectionError)
    }

}