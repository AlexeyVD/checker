package com.avd.checker.ext

import com.avd.checker.domain.model.time_data.FixedIntervalTimeData
import com.avd.checker.domain.model.time_data.TimeData
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test
import java.util.*
import java.util.Calendar.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */
class TimeDataExtKtTest {

    lateinit var calendar: Calendar
    lateinit var timeData: TimeData

    companion object {
        const val Y = 2018
        const val M = 9
        const val D = 11
    }

    @Before
    fun setup() {
        calendar = getInstance()
        calendar.set(Y, M, D)
        timeData = FixedIntervalTimeData(60)
    }

    @Test
    fun getYear() {
        timeData.getUnitValueByLts(calendar.timeInMillis, YEAR) shouldEqual Y
    }

    @Test
    fun getMonth() {
        timeData.getUnitValueByLts(calendar.timeInMillis, MONTH) shouldEqual M
    }

    @Test
    fun getDay() {
        timeData.getUnitValueByLts(calendar.timeInMillis, DAY_OF_MONTH) shouldEqual D
    }
}