package com.avd.checker.domain.checker_list

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

@CheckerListScope
class CheckerListInteractorImpl @Inject constructor(val repository: CheckerRepository) :
        CheckerListInteractor {
    override fun getCheckers(): Single<List<CheckerModel>> = repository.getCheckers()

    override fun subscribeCheckers(): Flowable<CheckerModel> = repository.subscribeCheckers()

    override fun unsubscribeCheckers() {
        repository.unsubscribeCheckers()
    }

}