package com.avd.checker.presentation.service

import android.app.IntentService
import android.content.Intent
import com.avd.checker.domain.repository.CheckerRepository
import com.avd.checker.ext.getApp
import javax.inject.Inject

class ApplyService : IntentService(TAG) {

    companion object {
        val TAG = ApplyService::class.java.simpleName!!
    }

    @Inject
    lateinit var repository: CheckerRepository

    override fun onCreate() {
        super.onCreate()
        getApp().getComponentsHolder()
                .getCheckersComponent()
                .inject(this)
    }

    override fun onHandleIntent(intent: Intent?) {
        repository.apply()
        stopSelf()
    }
}