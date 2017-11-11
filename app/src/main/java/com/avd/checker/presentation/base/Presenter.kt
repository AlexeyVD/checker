package com.avd.checker.presentation.base

/**
 * Created by Aleksey Dementyev on 07.11.2017.
 */

interface Presenter<in T> {
    fun attachView(view: T)
    fun detachView()
}