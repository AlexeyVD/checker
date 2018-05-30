package com.avd.checker.presentation.presenter

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.checker_detail.CheckerDetailInteractor
import com.avd.checker.presentation.base.BasePresenter
import com.avd.checker.presentation.view.checker_create.CheckerCreateView
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@CheckerListScope
class CheckerCreatePresenterImpl @Inject constructor(val interactor: CheckerDetailInteractor) :
        BasePresenter<CheckerCreateView>(), CheckerCreatePresenter {

    override fun createChecker(title: String, period: Int) {
        interactor.createChecker(title, period)
        view?.close()
    }

}