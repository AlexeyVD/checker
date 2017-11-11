package com.avd.checker.di.application

import com.avd.checker.data.CheckerRepositoryImpl
import com.avd.checker.domain.repository.CheckerRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideCheckerRepository(checkerRepository: CheckerRepositoryImpl): CheckerRepository
}