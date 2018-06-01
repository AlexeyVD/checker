package com.avd.checker.domain.checker_list

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

@CheckerListScope
class CheckerListInteractorImpl @Inject constructor(val repository: CheckerRepository) :
        CheckerListInteractor {

    override fun init() = repository.init()

    override fun getCheckers(lts: Long): List<CheckerModel> {
        val checkers = repository.getAll()

        checkers.forEach {
            if (it.isExpired(lts)) {
                it.isChecked = false
                it.updatePeriod(lts)
                repository.put(it)
            }
        }
        return checkers.sortedBy { it.isChecked }
    }

    override fun changeCheckerState(checker: CheckerModel): CheckerModel {
        checker.isChecked = !checker.isChecked
        repository.put(checker)
        return checker
    }
}