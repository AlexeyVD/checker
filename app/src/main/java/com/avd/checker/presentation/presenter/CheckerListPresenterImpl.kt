package com.avd.checker.presentation.presenter

import android.util.Log
import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import com.avd.checker.presentation.base.BasePresenter
import com.avd.checker.presentation.checker_list.CheckerListView
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@CheckerListScope
class CheckerListPresenterImpl @Inject constructor(val repository: CheckerRepository) :
        BasePresenter<CheckerListView>(), CheckerListPresenter {

    companion object {
        val TAG = CheckerListPresenterImpl::class.java.simpleName!!
    }

    private var items = ArrayList<CheckerModel>()
    private var checkersSub: Disposable? = null

    override fun onStart() {
        repository.getCheckers()
                .subscribe({
                    if (it.isEmpty()) {
                        mView?.showCreateButton()
                    } else {
                        items.addAll(it)
                        mView?.hideCreateButton()
                        mView?.setItems(it)
                    }
                    subscribeCheckers()
                }, {Log.e(TAG, it.message)})
    }

    override fun onStop() {
        detachView()
        checkersSub?.dispose()
        checkersSub = null
        repository.unsubscribeCheckers()
    }

    override fun onCreateButtonClick() {
        mView?.openDetailActivity()
    }

    private fun subscribeCheckers() {
        checkersSub = repository.subscribeCheckers()
                .subscribe({
                    if (items.isEmpty()) {
                        mView?.hideCreateButton()
                    }
                    items.add(it)
                    mView?.addItem(it)
                }, {Log.e(TAG, it.message)})
    }

}