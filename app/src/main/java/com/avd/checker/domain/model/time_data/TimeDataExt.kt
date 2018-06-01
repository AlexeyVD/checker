package com.avd.checker.domain.model.time_data

import com.avd.checker.domain.model.time_data.TimeData.Companion.DAY
import com.avd.checker.domain.model.time_data.TimeData.Companion.HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_DAY
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_MINUTE
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_WEEK
import com.avd.checker.domain.model.time_data.TimeData.Companion.MINUTE
import com.avd.checker.domain.model.time_data.TimeData.Companion.MONTH
import com.avd.checker.domain.model.time_data.TimeData.Companion.WEEK
import com.avd.checker.domain.model.time_data.TimeData.Companion.YEAR
import java.util.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */


private val intervalTypes = listOf(MINUTE, HOUR, DAY, WEEK)

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

fun createTimeData(period: Int): TimeData {

    //FIXME fix period hardcode
    val interval = when (period) {
        0 -> MINUTE
        1 -> HOUR
        2 -> DAY
        3 -> WEEK
        4 -> MONTH
        else -> throw RuntimeException("Unsupported type of time data")
    }

    return getTimeData(interval)
}

fun lts() = System.currentTimeMillis()

fun getTimeData(type: Int): TimeData {
    return when (type) {
        MINUTE -> FixedIntervalTimeData(INTERVAL_MINUTE)
        HOUR -> FixedIntervalTimeData(INTERVAL_HOUR)
        DAY -> FixedIntervalTimeData(INTERVAL_DAY)
        WEEK -> FixedIntervalTimeData(INTERVAL_WEEK)
        MONTH -> MonthTimeData()
        else -> throw RuntimeException("Unsupported type of time data")
    }
}

fun getSelectionId(type: Int): Int {
    return when (type) {
        TimeData.MINUTE -> 0
        TimeData.HOUR -> 1
        TimeData.DAY -> 2
        TimeData.WEEK -> 3
        TimeData.MONTH -> 4
        else -> 0
    }
}

fun getTimeDataBySelection(selectionId: Int): Int {
    return when (selectionId) {
        0 -> MINUTE
        1 -> HOUR
        2 -> DAY
        3 -> WEEK
        4 -> MONTH
        else -> throw RuntimeException("Unsupported type of time data")
    }
}
