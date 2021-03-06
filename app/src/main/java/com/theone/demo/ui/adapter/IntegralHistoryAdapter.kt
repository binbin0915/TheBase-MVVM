package com.theone.demo.ui.adapter

import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.theone.demo.R
import com.theone.demo.data.model.bean.IntegralHistoryResponse
import com.theone.demo.databinding.ItemIntegralHistoryBinding
import com.theone.mvvm.core.base.adapter.TheBaseQuickAdapter


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
 * @describe 积分记录
 * @email 625805189@qq.com
 * @remark
 */
class IntegralHistoryAdapter : TheBaseQuickAdapter<IntegralHistoryResponse, ItemIntegralHistoryBinding>(
    R.layout.item_integral_history
) {

    override fun convert(holder: BaseDataBindingHolder<ItemIntegralHistoryBinding>, item: IntegralHistoryResponse) {
       holder.dataBinding?.run {
           bean = item
       }
    }

}