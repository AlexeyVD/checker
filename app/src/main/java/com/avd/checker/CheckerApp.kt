package com.avd.checker

import android.app.Application
import com.avd.checker.di.ComponentsHolder

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

class CheckerApp : Application() {

    private lateinit var componentsHolder: ComponentsHolder

    override fun onCreate() {
        super.onCreate()
        componentsHolder = ComponentsHolder(this)
    }

    fun getComponentsHolder() = componentsHolder
}