package com.avd.checker.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.avd.checker.data.db.CheckersMainContract.Checkers.Companion.COLUMN_NAME_ID
import com.avd.checker.data.db.CheckersMainContract.Checkers.Companion.COLUMN_NAME_PERIOD
import com.avd.checker.data.db.CheckersMainContract.Checkers.Companion.COLUMN_NAME_TIME_UNIT
import com.avd.checker.data.db.CheckersMainContract.Checkers.Companion.COLUMN_NAME_TITLE
import com.avd.checker.data.db.CheckersMainContract.Checkers.Companion.TABLE_NAME
import com.avd.checker.data.db.CheckersMainContract.Companion.DB_NAME
import com.avd.checker.data.db.CheckersMainContract.Companion.DB_VERSION
import javax.inject.Inject

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

class DbHelper @Inject constructor(val context: Context) :
        SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {


    companion object {
        val SQL_CREATE_CHECKERS = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME_ID + " INTEGER NOT NULL PRIMARY KEY, " +
                COLUMN_NAME_TITLE + " TEXT NOT NULL, " +
                COLUMN_NAME_PERIOD + " INTEGER NOT NULL, " +
                COLUMN_NAME_TIME_UNIT + " INTEGER NOT NULL " +
                ")"
    }

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

}