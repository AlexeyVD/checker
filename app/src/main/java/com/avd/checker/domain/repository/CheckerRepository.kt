package com.avd.checker.domain.repository

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

interface CheckerRepository {

    /**
     * @return generated id for new checker
     */
    fun generateId(): Int

    /**
     * @return Single with list of existing [CheckerModel] checkers
     */
    fun getCheckers(): Single<List<CheckerModel>>

    /**
     * Adds [checker] to repository
     */
    fun addChecker(checker: CheckerModel)

    /**
     * Updates [checker] in repository
     */
    fun updateChecker(checker: CheckerModel)

    /**
     * Subscribes checkers changing
     */
    fun subscribeCheckers(): Flowable<CheckerModel>

    /**
     * Unsubscribes checkers changing
     */
    fun unsubscribeCheckers()
}