package com.avd.checker.presentation.view.checker_change

import com.avd.checker.domain.model.CheckerDto

interface CheckerChangeView {
    fun setData(checker: CheckerDto)
    fun showDeleteDialog()
    fun onDeleteEvent()
}