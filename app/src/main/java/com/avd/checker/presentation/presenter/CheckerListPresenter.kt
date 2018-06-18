package com.avd.checker.presentation.presenter

import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.Presenter
import com.avd.checker.presentation.view.checker_list.CheckerListView

/**
 * Created by Aleksey Dementyev on 07.11.2017.
 */

interface CheckerListPresenter : Presenter<CheckerListView> {

    /**
     * Loads list of checkers when app is started
     */
    fun onStart(lts: Long)

    /**
     * Handles app stopping
     */
    fun onStop()

    /**
     * Updates app data
     */
    fun onUpdate(lts: Long)

    /**
     * Handles click on creating button
     */
    fun onCreateButtonClick()

    /**
     * Handles click on checker item
     */
    fun onCheckerClick(checker: CheckerModel)

    /**
     * Handles click on state button
     */
    fun onStateButtonClick(checker: CheckerModel)

    /**
     * Handles click on settings button
     */
    fun onSettingsButtonClick()
}