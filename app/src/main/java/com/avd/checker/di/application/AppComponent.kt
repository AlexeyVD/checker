package com.avd.checker.di.application

import android.content.Context
import com.avd.checker.di.checkers.CheckerChangeComponent
import com.avd.checker.di.checkers.CheckersComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@Component(modules = [(NotificationModule::class), (RepositoryModule::class), (DbModule::class)])
@Singleton
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun notificationModule(notificationModule: NotificationModule): Builder
        fun dbModule(dbModule: DbModule): Builder
        fun build(): AppComponent
    }

    fun checkersComponentBuilder(): CheckersComponent.Builder

    fun checkerChangeComponentBuilder(): CheckerChangeComponent.Builder
}