package com.avd.checker.presentation.presenter

import com.avd.checker.domain.model.CheckerDto
import com.avd.checker.presentation.base.Presenter
import com.avd.checker.presentation.view.checker_change.CheckerChangeView

interface CheckerChangePresenter : Presenter<CheckerChangeView> {

    /**
     * Handles start event
     */
    fun onStart()

    /**
     * Applies changes
     */
    fun apply(title: String, timeDataType: Int, isChecked: Boolean)

    /**
     * Handles delete button click
     */
    fun onDeleteButtonClick()

    /**
     * Deletes checker
     */
    fun delete()
}