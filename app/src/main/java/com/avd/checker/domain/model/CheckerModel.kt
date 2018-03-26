package com.avd.checker.domain.model

import com.avd.checker.domain.model.time_data.TimeData

/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerModel (
        val id: Int,
        var checkerTitle: String,
        var timeData: TimeData,
        var isChecked: Boolean,
        var periodStartLts: Long)