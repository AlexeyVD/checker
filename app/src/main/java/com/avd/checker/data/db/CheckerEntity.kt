package com.avd.checker.data.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "checkers")
data class CheckerEntity(
        @PrimaryKey var id: Long,
        @ColumnInfo(name = "title") var title: String,
        @ColumnInfo(name = "time_data_type") var timeDataType: Int,
        @ColumnInfo(name = "is_checked") var isChecked: Boolean,
        @ColumnInfo(name = "period_start_lts") var periodStartLts: Long
)