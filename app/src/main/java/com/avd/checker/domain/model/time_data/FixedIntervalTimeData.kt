package com.avd.checker.domain.model.time_data

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
}