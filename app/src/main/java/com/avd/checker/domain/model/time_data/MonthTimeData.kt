package com.avd.checker.domain.model.time_data

import com.avd.checker.ext.get
import java.util.*
import java.util.Calendar.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */

class MonthTimeData : TimeData {

    override fun isExpired(prevLts: Long, lts: Long) = get(prevLts, MONTH) != get(lts, MONTH)

    override fun getTimeRemaining(lts: Long): Long {
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = lts
        calendar.add(MONTH, 1)
        calendar.set(DATE, calendar.getActualMinimum(DAY_OF_MONTH))
        return calendar.timeInMillis - lts
    }
}