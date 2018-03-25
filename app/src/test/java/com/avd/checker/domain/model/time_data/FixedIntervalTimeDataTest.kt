package com.avd.checker.domain.model.time_data

import org.amshove.kluent.shouldBe
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */
class FixedIntervalTimeDataTest {



    companion object {
        const val INTERVAL = 60L

        private lateinit var timeData: FixedIntervalTimeData

        @BeforeClass
        @JvmStatic
        fun setup() {
            timeData = FixedIntervalTimeData(INTERVAL)
        }
    }

    @Test
    fun isExpired() {
        timeData.isExpired(60, 180) shouldEqual true
    }

    @Test
    fun isNotExpired() {
        timeData.isExpired(30, 50) shouldEqual false
    }

    @Test
    fun getTimeRemaining() {
        timeData.getTimeRemaining(110) shouldEqual 10
        timeData.getTimeRemaining(180) shouldEqual INTERVAL
        timeData.getTimeRemaining(55) shouldEqual 5
    }
}