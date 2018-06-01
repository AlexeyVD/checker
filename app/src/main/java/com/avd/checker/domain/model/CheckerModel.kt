package com.avd.checker.domain.model

import com.avd.checker.domain.model.time_data.TimeData
import com.avd.checker.domain.model.time_data.getTimeData
import com.avd.checker.domain.model.time_data.lts

/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerModel (
        val id: Long,
        var title: String,
        var timeData: TimeData,
        var isChecked: Boolean,
        var periodStartLts: Long) : Model  {

    override fun id() = id

    fun isExpired(lts: Long) = timeData.isExpired(periodStartLts, lts)

    fun getTimeRemaining(lts: Long) = timeData.getTimeRemaining(lts)

    fun updatePeriod(lts: Long) {
        periodStartLts = timeData.getPrevTimeUnitLts(lts)
    }
}