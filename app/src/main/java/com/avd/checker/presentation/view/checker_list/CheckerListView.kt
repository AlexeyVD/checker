package com.avd.checker.presentation.checker_list

import com.avd.checker.domain.model.CheckerModel

/**
 * Created by Aleksey Dementyev on 07.11.2017.
 */

interface CheckerListView {
    fun setItems(items: List<CheckerModel>)
    fun addItem(item: CheckerModel)
    fun hideCreateButton()
    fun showCreateButton()
    fun openDetailActivity()
}