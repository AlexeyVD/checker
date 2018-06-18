package com.avd.checker.presentation.view.settings

import android.os.Bundle
import android.support.v7.app.ActionBar
import com.avd.checker.R
import com.avd.checker.ext.getAppVersion
import com.avd.checker.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_settings.*

/**
 * Created by Aleksey Dementyev on 09.06.2018.
 */

class SettingsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar_settings)
        supportActionBar?.let { initToolbar(it) }
        initSettings()
    }

    override fun getLayoutId() = R.layout.activity_settings

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initToolbar(actionBar: ActionBar) {
        actionBar.title = getString(R.string.settings)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
    }

    private fun initSettings() {
        version.text = getAppVersion()
    }
}