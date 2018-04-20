package com.avd.checker.domain.checker_list

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

interface CheckerListInteractor {

    /**
     * Init repository
     */
    fun init(): Completable

    /**
     * @return List of existing [CheckerModel] checkers
     */
    fun getCheckers(lts: Long): List<CheckerModel>

    /**
     * @return Flowable that emits [CheckerModel] checker, when it is created or updated
     */
    fun subscribeCheckers(): Flowable<CheckerModel>

    /**
     * Remove subscription of [CheckerModel] checkers changing
     */
    fun unsubscribeCheckers()

    /**
     * Changes [checker] isChecked state
     * @return updated [checker]
     */
    fun changeCheckerState(checker: CheckerModel): CheckerModel
}