package com.theone.demo.ui.fragment

import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import com.qmuiteam.qmui.util.QMUIDisplayHelper
import com.qmuiteam.qmui.widget.QMUITopBarLayout
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView
import com.qmuiteam.qmui.widget.grouplist.QMUIGroupListView
import com.theone.demo.R
import com.theone.mvvm.base.fragment.BaseVmFragment
import com.theone.mvvm.base.viewmodel.BaseViewModel
import com.theone.mvvm.ext.qmui.*
import com.theone.mvvm.util.ToastUtil
import kotlinx.android.synthetic.main.fragment_test.*


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
 * @date 2021/2/25 0025
 * @describe TODO
 * @email 625805189@qq.com
 * @remark
 */
class TestFragment : BaseVmFragment<BaseViewModel>(), CompoundButton.OnCheckedChangeListener,View.OnClickListener {

    override fun getLayoutId(): Int = R.layout.fragment_test

    override fun initTopBar(topBar: QMUITopBarLayout?) {
        topBar?.setTitle(this.javaClass.simpleName)
    }

    override fun onLazyInit() {

    }

    override fun onViewCreated(rootView: View) {
        val normal = groupListView.createNormalItem("Title")
        val detail = groupListView.createDetailItem("Title", "this is detail",R.drawable.svg_heart)
        val switch = groupListView.createSwitchItem("Title", "this is detail", false, -1,this)

        val logo = ImageView(mActivity)
        val size = QMUIDisplayHelper.dp2px(mActivity,40)
        logo.layoutParams = ViewGroup.LayoutParams(size,size)
        logo.setImageResource(R.drawable.svg_heart)
        val custom = groupListView.createCustomViewItem("Title","this is detail",-1,logo)

        showTips(false,false,normal)
        showTips(false,true,detail)
        showTips(true,true,custom)
        groupListView.addToGroup(this,normal,detail)
        groupListView.addToGroup(this,switch,custom)

    }

    override fun createObserver() {

    }

    override fun initData() {

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        ToastUtil.show(isChecked.toString())
    }

    override fun onClick(v: View?) {


    }


}