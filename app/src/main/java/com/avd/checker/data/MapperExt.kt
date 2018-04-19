package com.avd.checker.data

import com.avd.checker.data.db.CheckerEntity
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.model.time_data.getTimeData

fun CheckerModel.toEntity() =
        CheckerEntity(id, title, timeData.getType(), isChecked, periodStartLts)

fun CheckerEntity.toModel() =
        CheckerModel(id, title, getTimeData(timeDataType), isChecked, periodStartLts)