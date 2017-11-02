package com.avd.checker.presentation.checker_list

import android.view.View
import com.avd.checker.R
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.BaseAdapter

/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerListAdapter : BaseAdapter<CheckerModel, CheckerViewHolder>() {
    override fun getItemLayoutId() = R.layout.item_checker_list

    override fun getViewHolder(itemView: View) = CheckerViewHolder(itemView)
}