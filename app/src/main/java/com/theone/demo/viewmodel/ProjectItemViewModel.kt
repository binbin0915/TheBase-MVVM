package com.theone.demo.viewmodel

import androidx.lifecycle.rxLifeScope
import com.theone.demo.data.model.bean.ArticleResponse
import com.theone.demo.net.PagerResponse
import com.theone.demo.net.Url
import rxhttp.wrapper.param.RxHttp
import rxhttp.wrapper.param.toResponse


//  ┏┓　　　┏┓
//┏┛┻━━━┛┻┓
//┃　　　　　　　┃
//┃　　　━　　　┃
//┃　┳┛　┗┳　┃
//┃　　　　　　　┃
//┃　　　┻　　　┃
//┃　　　　　　　┃
//┗━┓　　　┏━┛
//    ┃　　　┃                  神兽保佑
//    ┃　　　┃                  永无BUG！
//    ┃　　　┗━━━┓
//    ┃　　　　　　　┣┓
//    ┃　　　　　　　┏┛
//    ┗┓┓┏━┳┓┏┛
//      ┃┫┫　┃┫┫
//      ┗┻┛　┗┻┛
/**
 * @author The one
 * @date 2021/3/3 0003
 * @describe TODO
 * @email 625805189@qq.com
 * @remark
 */
class ProjectItemViewModel : BaseDemoViewModel<ArticleResponse>() {

    var mId: Int = 0

    override fun requestServer() {
        rxLifeScope.launch({
            val response = RxHttp.get(Url.PROJECT_DATA, mPage.value,mId)
                .setCacheMode(getCacheMode())
                .toResponse<PagerResponse<List<ArticleResponse>>>()
                .await()
            onSuccess(response)
        }, {
            onError(it)
        })
    }

}