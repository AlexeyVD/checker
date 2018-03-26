package com.avd.checker.domain.repository

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

interface CheckerRepository {
    fun generateId(): Int
    fun getCheckers(): Single<List<CheckerModel>>
    fun addChecker(checker: CheckerModel)
    fun subscribeCheckers(): Flowable<CheckerModel>
    fun unsubscribeCheckers()
}