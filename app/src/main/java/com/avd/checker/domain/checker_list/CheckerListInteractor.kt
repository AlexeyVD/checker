package com.avd.checker.domain.checker_list

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

interface CheckerListInteractor {
    fun getCheckers(): Single<List<CheckerModel>>
    fun subscribeCheckers(): Flowable<CheckerModel>
    fun unsubscribeCheckers()
}