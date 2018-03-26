package com.avd.checker.ext

import com.avd.checker.domain.model.time_data.FixedIntervalTimeData
import com.avd.checker.domain.model.time_data.TimeData
import java.util.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */


fun TimeData.getTimeUnitByLts(lts: Long, timeUnit: Int): Int {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = lts
    return calendar.get(timeUnit)
}

fun createTimeData(period: String): TimeData = FixedIntervalTimeData(3600)

fun lts() = System.currentTimeMillis()