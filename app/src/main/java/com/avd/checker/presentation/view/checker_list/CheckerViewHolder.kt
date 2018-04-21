package com.avd.checker.presentation.view.checker_list

import android.view.View
import com.avd.checker.R
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.ext.gone
import com.avd.checker.ext.setBackgroundDrawableId
import com.avd.checker.ext.setTextColorId
import com.avd.checker.ext.visible
import com.avd.checker.presentation.base.BaseViewHolder
import kotlinx.android.synthetic.main.activity_checker_detail.view.*
import kotlinx.android.synthetic.main.item_checker_list.view.*

/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerViewHolder(itemView: View, private val listener: OnCheckerClickListener?) :
        BaseViewHolder<CheckerModel>(itemView) {
    lateinit var item: CheckerModel

    private val onItemClick = View.OnClickListener{ listener?.onItemClick(item) }
    private val onStateClick = View.OnClickListener{ listener?.onStateButtonClick(item) }

    override fun bind(item: CheckerModel) {
        this.item = item
        itemView.setOnClickListener(onItemClick)
        itemView.state_button.setOnClickListener(onStateClick)
        bindData()
    }

    private fun bindData() {
        itemView.check_title.text = this.item.title

        if (item.isChecked) {
            itemView.check_title.setTextColorId(R.color.whiteText)
            itemView.remaining.setTextColorId(R.color.whiteText)
            itemView.state_button.gone()
            itemView.setBackgroundDrawableId(R.drawable.bg_green_button_ripple)
        }
        else {
            itemView.check_title.setTextColorId(R.color.primaryText)
            itemView.remaining.setTextColorId(R.color.descriptionText)
            itemView.state_button.visible()
            itemView.state_button.text = itemView.context.getString(R.string.done)
            itemView.setBackgroundDrawableId(R.drawable.bg_list_item_ripple)
        }
    }
}