package com.avd.checker.presentation.checker_list

import android.view.View
import com.avd.checker.R
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.ext.setBackgroundColorId
import com.avd.checker.ext.setBackgroundDrawableId
import com.avd.checker.ext.setTextColorId
import com.avd.checker.presentation.base.BaseViewHolder
import kotlinx.android.synthetic.main.item_checker_list.view.*

/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerViewHolder(itemView: View) : BaseViewHolder<CheckerModel>(itemView) {
    lateinit var mItem: CheckerModel

    override fun bind(item: CheckerModel) {
        mItem = item
        itemView.check_title.text = mItem.checkerTitle
        itemView.remaining.text = mItem.remaining
//        itemView.check_box.isChecked = mItem.isChecked

//        if (Math.random() > 0.3) {
//            itemView.setBackgroundDrawableId(R.drawable.bg_list_item_ripple)
//            itemView.check_title.setTextColorId(R.color.whiteText)
//            itemView.remaining.setTextColorId(R.color.whiteText)
//        } else {
//            itemView.setBackgroundColorId(R.color.bg_green)
//            itemView.check_title.setTextColorId(R.color.pinkText)
//            itemView.remaining.setTextColorId(R.color.pinkText)
//        }
    }
}