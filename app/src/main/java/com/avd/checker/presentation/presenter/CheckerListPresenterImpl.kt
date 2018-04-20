package com.avd.checker.presentation.presenter

import android.util.Log
import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.checker_list.CheckerListInteractor
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.BasePresenter
import com.avd.checker.presentation.view.checker_list.CheckerListView
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@CheckerListScope
class CheckerListPresenterImpl @Inject constructor(val interactor: CheckerListInteractor) :
        BasePresenter<CheckerListView>(), CheckerListPresenter {

    companion object {
        val TAG = CheckerListPresenterImpl::class.java.simpleName!!
    }

    private val items = HashMap<Long, CheckerModel>()
    private var checkersSub: Disposable? = null

    override fun onStart(lts: Long) {
        interactor.init()
                .subscribe({ addCheckers(lts) }, { Log.e(TAG, it.message) })
        subscribeCheckers()
    }

    override fun onStop() {
        detachView()
        checkersSub?.dispose()
        checkersSub = null
        interactor.unsubscribeCheckers()
    }

    override fun onCreateButtonClick() {
        view?.onCreateRequest()
    }

    override fun onCheckerClick(checker: CheckerModel) {
        view?.onChangeRequest()
    }

    override fun onStateButtonClick(checker: CheckerModel) {
        val item = interactor.changeCheckerState(checker)
        items[item.id] = item
        view?.onCheckerChanged(item)
    }

    private fun subscribeCheckers() {
        checkersSub = interactor.subscribeCheckers()
                .subscribe({
                    if (items.isEmpty()) {
                        view?.hideCreateButton()
                    }
                    items[it.id] = it
                    view?.addItem(it)
                }, { Log.e(TAG, it.message) })
    }

    private fun addCheckers(lts: Long) {
        val checkers = interactor.getCheckers(lts)

        if (checkers.isEmpty()) {
            view?.showCreateButton()
        } else {
            checkers.forEach { items[it.id] = it }
            view?.hideCreateButton()
            view?.setItems(checkers)
        }
    }
}