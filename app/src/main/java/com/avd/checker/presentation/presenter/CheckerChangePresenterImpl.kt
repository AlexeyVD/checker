package com.avd.checker.presentation.presenter

import com.avd.checker.domain.checker_change.CheckerChangeInteractor
import com.avd.checker.presentation.base.BasePresenter
import com.avd.checker.presentation.view.checker_change.CheckerChangeView

class CheckerChangePresenterImpl(private val interactor: CheckerChangeInteractor) :
        BasePresenter<CheckerChangeView>(), CheckerChangePresenter {

    override fun onStart() {
        view?.setData(interactor.get())
    }

    override fun apply(title: String, timeDataType: Int, isChecked: Boolean) {
        interactor.apply(title, timeDataType, isChecked)
    }

    override fun onDeleteButtonClick() {
        view?.showDeleteDialog()
    }

    override fun delete() {
        interactor.delete()
        view?.onDeleteEvent()
    }
}