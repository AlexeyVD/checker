package com.avd.checker.presentation.view.checker_list

import android.view.View
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_checker_list.view.*

/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerViewHolder(itemView: View) : BaseViewHolder<CheckerModel>(itemView) {
    lateinit var mItem: CheckerModel

    override fun bind(item: CheckerModel) {
        mItem = item
        itemView.check_title.text = mItem.title
//        itemView.remaining.text = mItem.remaining
    }
}