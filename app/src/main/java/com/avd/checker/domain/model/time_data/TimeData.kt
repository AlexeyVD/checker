package com.avd.checker.domain.model.time_data

/**
 * Created by Aleksey Dementyev on 24.03.2018.
 */

interface TimeData {

    companion object {
        const val MINUTE = 1
        const val HOUR = 2
        const val DAY = 3
        const val WEEK = 4
        const val MONTH = 5
        const val YEAR = 6

        const val INTERVAL_MINUTE: Long = 60_000
        const val INTERVAL_HOUR: Long = INTERVAL_MINUTE * 60
        const val INTERVAL_DAY: Long = INTERVAL_HOUR * 24
        const val INTERVAL_WEEK: Long = INTERVAL_DAY * 7
    }

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

    /**
     * @return type of time data
     */
    fun getType(): Int
}