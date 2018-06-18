package com.avd.checker.presentation.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;



/**
 * Created by Aleksey Dementyev on 10.10.2017.
 */

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initCrashlytics()
        setContentView(getLayoutId())
    }

    abstract fun getLayoutId() : Int

    fun setFragment(containerId : Int, fragment : Fragment, tag : String?) {
        val fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(containerId, fragment, tag);
        fragmentTransaction.commit();
    }

    private fun initCrashlytics() {
        try {
            Fabric.with(this, Crashlytics())
        } catch (e: Exception) {
            Log.e("BaseActivity", e.message)
        }
    }
}