package com.theone.demo.ui.fragment.sample

import android.view.View
import com.qmuiteam.qmui.widget.grouplist.QMUICommonListItemView
import com.theone.demo.R
import com.theone.demo.databinding.FragmentSampleBinding
import com.theone.demo.ui.fragment.home.HomeFragment
import com.theone.mvvm.ext.qmui.addToGroup
import com.theone.mvvm.base.viewmodel.BaseViewModel
import com.theone.mvvm.core.base.fragment.BaseCoreFragment
import com.theone.mvvm.ext.qmui.createItem
import com.theone.mvvm.ext.qmui.setTitleWithBackBtn


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
class SampleFragment : BaseCoreFragment<BaseViewModel, FragmentSampleBinding>(),
    View.OnClickListener {

    override fun getLayoutId(): Int = R.layout.fragment_sample

    lateinit var mRecyclerPager: QMUICommonListItemView
    lateinit var mGroupListView: QMUICommonListItemView
    lateinit var mTest: QMUICommonListItemView
    lateinit var mCrash: QMUICommonListItemView

    override fun initView(rootView: View) {
        getTopBar()?.setTitleWithBackBtn("示例", this)
        mBinding.groupListView.run {
            mRecyclerPager = createItem("BaseRecyclerPagerFragment")
            mGroupListView = createItem("QMUIGroupListView")
            mTest = createItem("Test")
            mCrash = createItem("崩溃测试")
            addToGroup(mRecyclerPager, mGroupListView, title = "ui", listener = this@SampleFragment)
            addToGroup(mCrash, title = "工具", listener = this@SampleFragment)
            addToGroup(mTest, title = "其他")
        }
    }

    override fun onLazyInit() {

    }

    override fun onClick(v: View?) {
        if(v == mCrash){
             arrayListOf<String>()[1]
            return
        }
        startFragment(
            when (v) {
                mRecyclerPager -> HomeFragment()
                mGroupListView -> GroupListViewFragment()
                else -> TestFragment()
            }
        )
    }

    override fun initData() {
    }

    override fun createObserver() {
    }

}