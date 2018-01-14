package com.avd.checker.data.db

import android.provider.BaseColumns

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

class CheckersMainContract {

    companion object {
        val DB_NAME = "checkers_main"
        val DB_VERSION = 1
    }

    abstract class Checkers : BaseColumns {
        companion object {
            val TABLE_NAME = "checkers"
            val COLUMN_NAME_ID = "id"
            val COLUMN_NAME_TITLE = "title"
            val COLUMN_NAME_PERIOD = "period"
            val COLUMN_NAME_TIME_UNIT = "time_unit"
        }

    }
}