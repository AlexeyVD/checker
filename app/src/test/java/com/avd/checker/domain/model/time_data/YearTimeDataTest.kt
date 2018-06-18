package com.avd.checker.domain.model.time_data

import org.amshove.kluent.shouldEqual
import org.junit.Assert.*
import org.junit.BeforeClass
import org.junit.Test
import java.util.*

/**
 * Created by Aleksey Dementyev on 09.06.2018.
 */
class YearTimeDataTest {

    companion object {
        lateinit var timeData: YearTimeData
        lateinit var prevCalendar: Calendar
        lateinit var newCalendar: Calendar

        @BeforeClass
        @JvmStatic
        fun setup() {
            timeData = YearTimeData()
            prevCalendar = Calendar.getInstance()
            newCalendar = Calendar.getInstance()
            prevCalendar.resetTime()
            newCalendar.resetTime()
        }
    }

    @Test
    fun isExpiredNextYear() {
        prevCalendar.set(2016, 11, 28)
        newCalendar.set(2017, 12, 1)
        timeData.isExpired(prevCalendar.timeInMillis, newCalendar.timeInMillis) shouldEqual true
    }

    @Test
    fun isExpiredOtherYear() {
        prevCalendar.set(2015, 11, 28)
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

    @Test
    fun getPrevTimeUnitLts() {
        prevCalendar.set(2018, 3, 21)
        val expected = Calendar.getInstance()
        expected.set(2018, expected.getActualMinimum(Calendar.MONTH),
                expected.getActualMinimum(Calendar.DATE))
        expected.resetTime()

        timeData.getPrevTimeUnitLts(prevCalendar.timeInMillis) shouldEqual expected.timeInMillis
    }
}