package com.avd.checker.domain.repository

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

interface CheckerRepository {

    /**
     * @return Single with list of existing [CheckerModel] checkers
     */
    fun getCheckers(): Single<List<CheckerModel>>

    /**
     * Puts checker to repository or replaces it if exists
     */
    fun putChecker(checker: CheckerModel): Completable

    /**
     * Subscribes checkers changing
     */
    fun subscribeCheckers(): Flowable<CheckerModel>

    /**
     * Unsubscribes checkers changing
     */
    fun unsubscribeCheckers()
}