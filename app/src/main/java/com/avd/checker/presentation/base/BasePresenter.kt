package com.avd.checker.presentation.base

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

open class BasePresenter<T> : Presenter<T> {

    protected var mView: T? = null

    override fun attachView(view: T) {
        mView = view
    }

    override fun detachView() {
        mView = null
    }

}