package com.avd.checker.di

import android.content.Context
import com.avd.checker.di.application.NotificationModule
import com.avd.checker.di.application.DaggerAppComponent

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

class ComponentsHolder(val context: Context) {

    private val appComponent = DaggerAppComponent.builder()
            .context(context)
            .notificationModule(NotificationModule())
            .build()

    fun getCheckersComponent() = appComponent.checkersComponentBuilder().build()
}