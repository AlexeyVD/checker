package com.avd.checker.domain.checker_detail

import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import com.avd.checker.domain.model.time_data.createTimeData
import com.avd.checker.domain.model.time_data.lts
import io.reactivex.Completable
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */


@CheckerListScope
class CheckerDetailInteractorImpl @Inject constructor(val repository: CheckerRepository) :
        CheckerDetailInteractor {

    override fun createChecker(title: String, period: String) {
        val timeData = createTimeData(period)
        repository.createChecker(CheckerModel(repository.generateId(), title, timeData,
                false, timeData.getPrevTimeUnitLts(lts())))
    }
}