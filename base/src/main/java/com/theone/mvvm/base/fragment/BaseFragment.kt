package com.theone.mvvm.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.qmuiteam.qmui.arch.QMUIFragment
import com.qmuiteam.qmui.util.QMUIStatusBarHelper


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
abstract class BaseFragment : QMUIFragment(), LifecycleObserver {

    lateinit var mActivity: AppCompatActivity

    /**
     * 是否为根Fragment： getParentFragment() 为空
     */
    var isIndexFragment = false
    var mIsFirstLayInit = true

    abstract fun getLayoutId(): Int
    abstract fun initView(savedInstanceState: Bundle?)

    override fun onCreateView(): View {
        return layoutInflater.inflate(getLayoutId(), null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(savedInstanceState)
        lazyViewLifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isIndexFragment = null == parentFragment
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    open fun onLazyResume() {
        if (isNeedChangeStatusBarMode()) {
            updateStatusBarMode(isStatusBarLightMode())
        }
        if (!isIndexFragment) {
            checkLazyInit()
        }
    }

    override fun onEnterAnimationEnd(animation: Animation?) {
        super.onEnterAnimationEnd(animation)
        if (isIndexFragment) {
            checkLazyInit()
        }
    }

    /**
     * 懒加载分两种情况
     * 1.在动画结束后开始进行加载
     * 2.当前Fragment为子Fragment时，比如ViewPager的ItemFragment,或者点击切换的，这种情况下当界面可见时才进行加载
     *
     * 这里自动根据 [.isIndexFragment] 判断是以哪种情况进行懒加载
     */
    abstract fun onLazyInit()

    private fun checkLazyInit() {
        if (mIsFirstLayInit) {
            mIsFirstLayInit = false
            onLazyInit()
        }
    }

    /**
     * @return 是否要进行对状态栏的处理
     * @remark 默认当为根fragment时才进行处理
     */
    protected open fun isNeedChangeStatusBarMode(): Boolean {
        return isIndexFragment
    }

    /**
     * @return 是否设置状态栏LightMode 深色图标 白色背景
     * @remark 默认根据当前TopBarLayout的背景颜色是否为白色或是否存在渐变色背景进行判断
     */
    protected open fun isStatusBarLightMode(): Boolean {
        return true
    }

    /**
     * 更新状态栏模式
     *
     * @param isLight true 设置状态栏黑色字体图标，
     *
     * 支持 4.4 以上版本 MIUI 和 Flyme，以及 6.0 以上版本的其他 Android
     */
    protected open fun updateStatusBarMode(isLight: Boolean) {
        if (isLight) {
            QMUIStatusBarHelper.setStatusBarLightMode(baseFragmentActivity)
        } else {
            QMUIStatusBarHelper.setStatusBarDarkMode(baseFragmentActivity)
        }
    }

    /**
     * 向外提供的关闭方法
     */
    open fun finish() {
        popBackStack()
    }

}