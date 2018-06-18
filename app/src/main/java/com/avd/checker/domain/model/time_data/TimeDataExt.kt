package com.avd.checker.domain.model.time_data

import com.avd.checker.domain.model.time_data.TimeData.Companion.DAY
import com.avd.checker.domain.model.time_data.TimeData.Companion.FOUR_HOURS
import com.avd.checker.domain.model.time_data.TimeData.Companion.HALF_HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_DAY
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_FOUR_HOURS
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_HALF_HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_MINUTE
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_TWELVE_HOURS
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_TWO_HOURS
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_WEEK
import com.avd.checker.domain.model.time_data.TimeData.Companion.MINUTE
import com.avd.checker.domain.model.time_data.TimeData.Companion.MONTH
import com.avd.checker.domain.model.time_data.TimeData.Companion.TWELVE_HOURS
import com.avd.checker.domain.model.time_data.TimeData.Companion.TWO_HOURS
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
        1 -> HALF_HOUR
        2 -> HOUR
        3 -> TWO_HOURS
        4 -> FOUR_HOURS
        5 -> TWELVE_HOURS
        6 -> DAY
        7 -> WEEK
        8 -> MONTH
        9 -> YEAR
        else -> throw RuntimeException("Unsupported type of time data")
    }

    return getTimeData(interval)
}

fun lts() = System.currentTimeMillis()

fun getTimeData(type: Int): TimeData {
    return when (type) {
        MINUTE -> FixedIntervalTimeData(INTERVAL_MINUTE)
        HALF_HOUR -> FixedIntervalTimeData(INTERVAL_HALF_HOUR)
        HOUR -> FixedIntervalTimeData(INTERVAL_HOUR)
        TWO_HOURS -> FixedIntervalTimeData(INTERVAL_TWO_HOURS)
        FOUR_HOURS -> FixedIntervalTimeData(INTERVAL_FOUR_HOURS)
        TWELVE_HOURS -> FixedIntervalTimeData(INTERVAL_TWELVE_HOURS)
        DAY -> FixedIntervalTimeData(INTERVAL_DAY)
        WEEK -> FixedIntervalTimeData(INTERVAL_WEEK)
        MONTH -> MonthTimeData()
        YEAR -> YearTimeData()
        else -> throw RuntimeException("Unsupported type of time data")
    }
}

fun getSelectionId(type: Int): Int {
    return when (type) {
        MINUTE -> 0
        HALF_HOUR -> 1
        HOUR -> 2
        TWO_HOURS -> 3
        FOUR_HOURS -> 4
        TWELVE_HOURS -> 5
        DAY -> 6
        WEEK -> 7
        MONTH -> 8
        YEAR -> 9
        else -> 0
    }
}

fun getTimeDataBySelection(selectionId: Int): Int {
    return when (selectionId) {
        0 -> MINUTE
        1 -> HALF_HOUR
        2 -> HOUR
        3 -> TWO_HOURS
        4 -> FOUR_HOURS
        5 -> TWELVE_HOURS
        6 -> DAY
        7 -> WEEK
        8 -> MONTH
        9 -> YEAR
        else -> throw RuntimeException("Unsupported type of time data")
    }
}
