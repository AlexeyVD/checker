package com.avd.checker.presentation.presenter

import com.avd.checker.presentation.base.Presenter
import com.avd.checker.presentation.checker_list.CheckerListView

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
     * Handles click on creating button
     */
    fun onCreateButtonClick()
}