package com.theone.demo.viewmodel

import com.theone.demo.app.util.ColorUtil
import com.theone.mvvm.base.viewmodel.BaseViewModel
import com.theone.mvvm.callback.databind.StringObservableField


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