package com.avd.checker.domain.model.time_data

import java.util.*
import java.util.Calendar.*

/**
 * Created by Aleksey Dementyev on 09.06.2018.
 */

class YearTimeData : TimeData {
    override fun isExpired(prevLts: Long, lts: Long) =
            getUnitValueByLts(prevLts, YEAR) != getUnitValueByLts(lts, YEAR)

    override fun getTimeRemaining(lts: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = lts
        calendar.add(Calendar.YEAR, 1)
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(MONTH))
        calendar.set(Calendar.DATE, calendar.getActualMinimum(DATE))
        calendar.resetTime()
        return calendar.timeInMillis - lts
    }

    override fun getPrevTimeUnitLts(lts: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = lts
        calendar.set(Calendar.MONTH, calendar.getActualMinimum(MONTH))
        calendar.set(Calendar.DATE, calendar.getActualMinimum(DATE))
        calendar.resetTime()

        return calendar.timeInMillis
    }

    override fun getNextTimeUnitLts(lts: Long) = lts + getTimeRemaining(lts)

    override fun getType() = TimeData.YEAR
}