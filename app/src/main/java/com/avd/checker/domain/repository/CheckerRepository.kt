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
     * @return next id
     */
    fun generateId(): Long

    /**
     * @return list of existing [CheckerModel] checkers
     */
    fun getCheckers(): List<CheckerModel>

    /**
     * Creates new checker
     */
    fun createChecker(checker: CheckerModel)

    /**
     * Puts checker to repository or replaces it if exists
     */
    fun putChecker(checker: CheckerModel)

    /**
     * Subscribes checkers changing
     */
    fun subscribeCheckers(): Flowable<CheckerModel>

    /**
     * Unsubscribes checkers changing
     */
    fun unsubscribeCheckers()

    /**
     * Init data source
     */
    fun init(): Completable

    /**
     * Applies changes in data source
     */
    fun apply()
}