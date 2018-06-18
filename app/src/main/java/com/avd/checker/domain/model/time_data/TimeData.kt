package com.avd.checker.domain.model.time_data

/**
 * Created by Aleksey Dementyev on 24.03.2018.
 */

interface TimeData {

    companion object {
        const val MINUTE = 1
        const val HALF_HOUR = 2
        const val HOUR = 3
        const val TWO_HOURS = 4
        const val FOUR_HOURS = 5
        const val TWELVE_HOURS = 6
        const val DAY = 7
        const val WEEK = 8
        const val MONTH = 9
        const val YEAR = 10

        const val MINUTE_TAG = "minute"
        const val HALF_HOUR_TAG = "half_hour"
        const val HOUR_TAG = "hour"
        const val TWO_HOURS_TAG = "two_hours"
        const val FOUR_HOURS_TAG = "four_hours"
        const val TWELVE_HOURS_TAG = "twelve_hours"
        const val DAY_TAG = "day"
        const val WEEK_TAG = "week"
        const val MONTH_TAG = "month"
        const val YEAR_TAG = "year"

        const val INTERVAL_MINUTE: Long = 60_000
        const val INTERVAL_HALF_HOUR: Long = INTERVAL_MINUTE * 30
        const val INTERVAL_HOUR: Long = INTERVAL_MINUTE * 60
        const val INTERVAL_TWO_HOURS: Long = INTERVAL_MINUTE * 60 * 2
        const val INTERVAL_FOUR_HOURS: Long = INTERVAL_MINUTE * 60 * 4
        const val INTERVAL_TWELVE_HOURS: Long = INTERVAL_MINUTE * 60 * 12
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

    /**
     * @return string tag of time data by type
     */
    fun getTag(): String {
        val type = getType()
        return when (type) {
            MINUTE -> MINUTE_TAG
            HALF_HOUR -> HALF_HOUR_TAG
            HOUR -> HOUR_TAG
            TWO_HOURS -> TWO_HOURS_TAG
            FOUR_HOURS -> FOUR_HOURS_TAG
            TWELVE_HOURS -> TWELVE_HOURS_TAG
            DAY -> DAY_TAG
            WEEK -> WEEK_TAG
            MONTH -> MONTH_TAG
            YEAR -> YEAR_TAG
            else -> throw RuntimeException("Unsupported type of time data")
        }
    }
}