package com.avd.checker.di.application

import android.arch.persistence.room.Room
import android.content.Context
import com.avd.checker.data.CheckerRepositoryImpl
import com.avd.checker.data.DataSource
import com.avd.checker.data.DbCheckersDataSource
import com.avd.checker.data.db.CheckersDatabase
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideCheckerRepository(checkerRepository: CheckerRepositoryImpl): CheckerRepository

    @Binds
    @Singleton
    fun provideCheckersDataSource(dataSource: DbCheckersDataSource): DataSource<CheckerModel>
}