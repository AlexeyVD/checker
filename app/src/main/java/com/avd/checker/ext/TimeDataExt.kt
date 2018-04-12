package com.avd.checker.ext

import com.avd.checker.domain.model.time_data.FixedIntervalTimeData
import com.avd.checker.domain.model.time_data.TimeData
import java.util.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */

/**
 * @return [timeUnit] value (day of week, day of month, month, year etc.) of [lts]
 */
fun TimeData.getUnitValueByLts(lts: Long, timeUnit: Int): Int {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = lts
    return calendar.get(timeUnit)
}

fun Calendar.resetTime() {
    set(Calendar.HOUR_OF_DAY, 0)
    set(Calendar.MINUTE, 0)
    set(Calendar.SECOND, 0)
    set(Calendar.MILLISECOND, 0)
}

fun createTimeData(period: String): TimeData = FixedIntervalTimeData(3600)

fun lts() = System.currentTimeMillis()