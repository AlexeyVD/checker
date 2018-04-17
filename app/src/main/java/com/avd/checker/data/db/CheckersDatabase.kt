package com.avd.checker.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [(CheckerEntity::class)], version = 1)
abstract class CheckersDatabase : RoomDatabase() {
    abstract fun checkerDao(): CheckerDao
}