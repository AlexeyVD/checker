package com.avd.checker.presentation.presenter

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import com.avd.checker.presentation.base.BasePresenter
import com.avd.checker.presentation.view.checker_detail.CheckerDetailView
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@CheckerListScope
class CheckerDetailPresenterImpl @Inject constructor(val repository: CheckerRepository) :
        BasePresenter<CheckerDetailView>(), CheckerDetailPresenter {

    override fun createChecker(title: String, period: String) {
        repository.addChecker(CheckerModel(title, period, false))
        mView?.close()
    }

}