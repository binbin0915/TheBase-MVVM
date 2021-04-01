package com.theone.demo.app.util

import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tencent.mmkv.MMKV


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
 * @date 2021/3/11 0011
 * @describe TODO
 * @email 625805189@qq.com
 * @remark
 */
object CacheUtil {

    private const val HISTORY: String = "search_history"
    private const val ANIMATION: String = "animation_type"
    private const val LAUNCHER: String = "launcher_mode"

    /**
     * 获取搜索历史缓存数据
     */
    fun getSearchHistoryData(): ArrayList<String> {
        val searchCacheStr = MMKVUtil.getString(HISTORY)
        if (!TextUtils.isEmpty(searchCacheStr)) {
            return Gson().fromJson(
                searchCacheStr
                , object : TypeToken<ArrayList<String>>() {}.type
            )
        }
        return arrayListOf()
    }

    /**
     * 设置搜索历史数据
     */
    fun setSearchHistoryData(searchResponseStr: String) {
        MMKVUtil.putString(HISTORY, searchResponseStr)
    }

    /**
     * 获取列表动画类型
     */
    fun getAnimationType():Int =  MMKVUtil.getInt(ANIMATION, 0)

    /**
     * 设置类表动画类型
     */
    fun setAnimationType(type:Int){
        MMKVUtil.putInt(ANIMATION, type)
    }

    /**
     * 是否开启启动页文字
     */
    fun isOpenLauncherText():Boolean =  MMKVUtil.getBoolean(LAUNCHER, true)

    /**
     * 设置启动页文字开关
     * @param open Boolean
     */
    fun setLauncherText(open:Boolean){
        MMKVUtil.putBoolean(LAUNCHER, open)
    }

}