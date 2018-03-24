package com.avd.checker.di.application

import android.app.NotificationManager
import android.content.Context
import com.avd.checker.presentation.notification.NotificationHandler
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 04.03.2018.
 */

@Module
class NotificationModule {

    @Provides
    @Singleton
    fun provideNotificationManager(context: Context) =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    @Provides
    @Singleton
    fun provideNotificationHandler(manager: NotificationManager) = NotificationHandler(manager)
}