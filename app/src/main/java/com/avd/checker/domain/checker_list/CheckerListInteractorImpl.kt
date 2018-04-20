package com.avd.checker.domain.checker_list

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

@CheckerListScope
class CheckerListInteractorImpl @Inject constructor(val repository: CheckerRepository) :
        CheckerListInteractor {

    override fun init() = repository.init()

    override fun getCheckers(lts: Long): List<CheckerModel> {
        val checkers = repository.getCheckers()

        checkers.forEach {
            if (it.isExpired(lts)) {
                it.isChecked = false
                it.updatePeriod(lts)
                repository.putChecker(it)
            }
        }
        return checkers
    }

    override fun subscribeCheckers(): Flowable<CheckerModel> = repository.subscribeCheckers()

    override fun unsubscribeCheckers() {
        repository.unsubscribeCheckers()
    }

    override fun changeCheckerState(checker: CheckerModel): CheckerModel {
        checker.isChecked = !checker.isChecked
        repository.putChecker(checker)
        return checker
    }
}