package com.avd.checker.presentation.view.checker_change

import android.os.Bundle
import android.support.v7.app.ActionBar
import com.avd.checker.R
import com.avd.checker.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_checker_change.*

class CheckerChangeActivity : BaseActivity(), CheckerChangeView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar_detail)
        supportActionBar?.let { initToolbar(it) }
    }

    override fun getLayoutId() = R.layout.activity_checker_change

    override fun onChanged() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDeleted() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initToolbar(actionBar: ActionBar) {
        actionBar.title = "Редактировать чекер"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
    }
}