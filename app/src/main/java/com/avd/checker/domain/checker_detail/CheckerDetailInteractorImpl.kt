package com.avd.checker.domain.checker_detail

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import com.avd.checker.ext.createTimeData
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */


@CheckerListScope
class CheckerDetailInteractorImpl @Inject constructor(val repository: CheckerRepository) :
        CheckerDetailInteractor {

    override fun addChecker(title: String, period: String) {
        val model = CheckerModel(repository.generateId(), title,
                createTimeData(period), false, 0)
        repository.addChecker(model)
    }
}