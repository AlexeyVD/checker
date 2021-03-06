package com.avd.checker.presentation.presenter

import com.avd.checker.presentation.base.Presenter
import com.avd.checker.presentation.view.checker_create.CheckerCreateView

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

interface CheckerCreatePresenter : Presenter<CheckerCreateView> {

    /**
     * Creates new checker
     */
    fun createChecker(title: String, period: Int)
}