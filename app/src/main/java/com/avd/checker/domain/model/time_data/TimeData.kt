package com.avd.checker.domain.model.time_data

/**
 * Created by Aleksey Dementyev on 24.03.2018.
 */

interface TimeData {
    fun isExpired(prevLts: Long, lts: Long): Boolean
    fun getTimeRemaining(lts: Long): Long
}