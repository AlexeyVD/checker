package com.avd.checker.domain.model.time_data

import org.amshove.kluent.shouldEqual
import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */
class MonthTimeDataTest {

    companion object {
        lateinit var timeData: MonthTimeData
        lateinit var prevCalendar: Calendar
        lateinit var newCalendar: Calendar

        @BeforeClass
        @JvmStatic
        fun setup() {
            timeData = MonthTimeData()
            prevCalendar = Calendar.getInstance()
            newCalendar = Calendar.getInstance()
        }
    }

    @Test
    fun isExpiredNextMonth() {
        prevCalendar.set(2017, 11, 28)
        newCalendar.set(2017, 12, 1)
        timeData.isExpired(prevCalendar.timeInMillis, newCalendar.timeInMillis) shouldEqual true
    }

    @Test
    fun isExpiredOtherMonth() {
        prevCalendar.set(2017, 11, 28)
        newCalendar.set(2018, 0, 6)
        timeData.isExpired(prevCalendar.timeInMillis, newCalendar.timeInMillis) shouldEqual true
    }

    @Test
    fun isNotExpired() {
        prevCalendar.set(2017, 11, 28)
        newCalendar.set(2017, 11, 30)
        timeData.isExpired(prevCalendar.timeInMillis, newCalendar.timeInMillis) shouldEqual false
    }

    @Test
    fun getTimeRemaining() {
        prevCalendar.set(2017, 11, 30)
        timeData.getTimeRemaining(prevCalendar.timeInMillis) shouldEqual 172_800_000
    }
}