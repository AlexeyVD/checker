package com.avd.checker.domain.model.time_data

import com.avd.checker.ext.getUnitValueByLts
import com.avd.checker.ext.resetTime
import java.util.*
import java.util.Calendar.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */

/**
 * [TimeData] implementation for MONTH time unit
 */
class MonthTimeData : TimeData {

    override fun isExpired(prevLts: Long, lts: Long) =
            getUnitValueByLts(prevLts, MONTH) != getUnitValueByLts(lts, MONTH)

    override fun getTimeRemaining(lts: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = lts
        calendar.add(MONTH, 1)
        calendar.set(DATE, calendar.getActualMinimum(DAY_OF_MONTH))
        calendar.resetTime()
        return calendar.timeInMillis - lts
    }

    override fun getPrevTimeUnitLts(lts: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = lts
        calendar.set(DATE, calendar.getActualMinimum(DAY_OF_MONTH))
        calendar.resetTime()

        return calendar.timeInMillis
    }

    override fun getNextTimeUnitLts(lts: Long) = lts + getTimeRemaining(lts)
}