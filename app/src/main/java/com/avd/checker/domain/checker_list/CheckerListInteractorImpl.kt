package com.avd.checker.domain.checker_list

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import com.avd.checker.ext.lts
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

@CheckerListScope
class CheckerListInteractorImpl @Inject constructor(val repository: CheckerRepository) :
        CheckerListInteractor {

    override fun getCheckers(lts: Long): Single<List<CheckerModel>> =
            repository.getCheckers()
                    .map{ updateStates(it, lts) }


    override fun subscribeCheckers(): Flowable<CheckerModel> = repository.subscribeCheckers()


    override fun unsubscribeCheckers() {
        repository.unsubscribeCheckers()
    }

    /**
     * Update [checkers] states at [lts] millis
     */
    private fun updateStates(checkers: List<CheckerModel>, lts: Long): List<CheckerModel> {

        checkers.forEach {
            if (it.isExpired(lts)) {
                it.isChecked = false
                it.updatePeriod(lts)
                repository.updateChecker(it)
            }
        }
        return checkers
    }
}