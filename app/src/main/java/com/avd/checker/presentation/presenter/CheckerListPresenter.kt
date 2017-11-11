package com.avd.checker.presentation.presenter

import com.avd.checker.presentation.base.Presenter
import com.avd.checker.presentation.checker_list.CheckerListView

/**
 * Created by Aleksey Dementyev on 07.11.2017.
 */

interface CheckerListPresenter : Presenter<CheckerListView> {
    fun onStart()
    fun onStop()
    fun onCreateButtonClick()
}