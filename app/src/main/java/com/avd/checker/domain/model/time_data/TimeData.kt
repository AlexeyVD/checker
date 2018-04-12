package com.avd.checker.domain.model.time_data

/**
 * Created by Aleksey Dementyev on 24.03.2018.
 */

interface TimeData {
    /**
     * Checks that [lts] is more then [prevLts] per 1 calendar time unit value in millis
     * For example, time unit values: SECOND = 1000, MINUTE = 60_000 etc.
     * @return true if [lts] - [prevLts] > time unit value or false otherwise
     */
    fun isExpired(prevLts: Long, lts: Long): Boolean

    /**
     * @return millis remaining from [lts] to the end of next time unit
     */
    fun getTimeRemaining(lts: Long): Long

    /**
     * @return millis of previous time unit from [lts]
     */
    fun getPrevTimeUnitLts(lts: Long): Long

    /**
     * @return millis of next time unit from [lts]
     */
    fun getNextTimeUnitLts(lts: Long): Long
}