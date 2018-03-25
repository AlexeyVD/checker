package com.avd.checker.ext

import com.avd.checker.domain.model.time_data.TimeData
import java.util.*

/**
 * Created by Aleksey Dementyev on 25.03.2018.
 */


fun TimeData.get(ts: Long, unit: Int): Int {
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = ts
    return calendar.get(unit)
}