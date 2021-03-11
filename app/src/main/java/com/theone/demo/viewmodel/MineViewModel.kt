package com.theone.demo.viewmodel

import androidx.lifecycle.rxLifeScope
import com.theone.demo.app.net.Url
import com.theone.demo.app.util.ColorUtil
import com.theone.demo.data.model.bean.ArticleResponse
import com.theone.demo.data.model.bean.IntegralResponse
import com.theone.mvvm.base.ext.request
import com.theone.mvvm.base.ext.util.logE
import com.theone.mvvm.base.viewmodel.BaseRequestViewModel
import com.theone.mvvm.base.viewmodel.BaseViewModel
import com.theone.mvvm.callback.databind.BooleanObservableField
import com.theone.mvvm.callback.databind.CharSequenceObservableField
import com.theone.mvvm.callback.databind.IntObservableField
import com.theone.mvvm.callback.databind.StringObservableField
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
 * @date 2021/3/4 0004
 * @describe TODO
 * @email 625805189@qq.com
 * @remark
 */
class MineViewModel : BaseViewModel() {

    var name = StringObservableField("请先登录")

    var id = StringObservableField("ID")

    var level = StringObservableField("等级")

    var integral = StringObservableField("积分")

    var rank = StringObservableField("排名")

    var imageUrl = StringObservableField(ColorUtil.randomImage())

}