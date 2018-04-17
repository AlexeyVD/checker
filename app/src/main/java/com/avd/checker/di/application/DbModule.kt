package com.avd.checker.di.application

import android.arch.persistence.room.Room
import android.content.Context
import com.avd.checker.data.db.CheckersDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    companion object {
        const val DB_NAME = "checkers_database"
    }

    @Provides
    @Singleton
    fun provideCheckersDatabase(context: Context) =
            Room.databaseBuilder(context, CheckersDatabase::class.java, DB_NAME)
                    .build()
}