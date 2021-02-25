package com.theone.demo.viewmodel

import androidx.lifecycle.rxLifeScope
import com.theone.demo.entity.Brand
import com.theone.demo.net.PageInfo
import com.theone.demo.net.Response
import com.theone.demo.net.Url
import com.theone.mvvm.base.viewmodel.BaseListViewModel
import rxhttp.toClass
import rxhttp.wrapper.cahce.CacheMode
import rxhttp.wrapper.param.RxHttp


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
 * @date 2021/2/22 0022
 * @describe TODO
 * @email 625805189@qq.com
 * @remark
 */
class BrandViewModel : BaseDemoViewModel<Brand>() {

    override fun requestServer() {
        rxLifeScope.launch({
            val response = RxHttp.get(Url.BRAND)
                .setCacheMode(getCacheMode())
                .toClass<Response<List<Brand>>>()
                .await()
            onSuccess(response)
        }, {
            onError(it)
        })
    }

}
