package com.avd.checker.domain.model.time_data

import com.avd.checker.domain.model.time_data.TimeData.Companion.DAY
import com.avd.checker.domain.model.time_data.TimeData.Companion.HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_DAY
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_HOUR
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_MINUTE
import com.avd.checker.domain.model.time_data.TimeData.Companion.INTERVAL_WEEK
import com.avd.checker.domain.model.time_data.TimeData.Companion.MINUTE
import com.avd.checker.domain.model.time_data.TimeData.Companion.WEEK

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */

/**
 * [TimeData] implementation for time units with fixed [intervalValue] (DAY, HOUR, MINUTE etc.)
 */
class FixedIntervalTimeData(private val intervalValue: Long) : TimeData {

    override fun isExpired(prevLts: Long, lts: Long) = lts - prevLts > intervalValue

    override fun getTimeRemaining(lts: Long) = intervalValue - lts % intervalValue

    override fun getPrevTimeUnitLts(lts: Long) = lts - lts % intervalValue

    override fun getNextTimeUnitLts(lts: Long) = lts + getTimeRemaining(lts)

    override fun getType(): Int {
        return when (intervalValue) {
            INTERVAL_MINUTE -> MINUTE
            INTERVAL_HOUR -> HOUR
            INTERVAL_DAY -> DAY
            INTERVAL_WEEK -> WEEK
            else -> 0
        }
    }
}