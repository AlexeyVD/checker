package com.avd.checker.presentation.view.checker_change

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.widget.TextView
import com.avd.checker.R
import com.avd.checker.ext.getStringArrayItem
import com.avd.checker.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_checker_change.*

class CheckerChangeActivity : BaseActivity(), CheckerChangeView {

    companion object {
        const val DEFAULT_TITLE = ""
        const val DEFAULT_PERIOD = 0
        const val TITLE = "title"
        const val PERIOD = "period"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(toolbar_detail)
        supportActionBar?.let { initToolbar(it) }

        initPresenter(intent.extras)
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

    private fun initPresenter(bundle: Bundle?) {
        val title = getCheckerTitle(bundle)
        val period = getCheckerPeriod(bundle)

        title_input.setText(title, TextView.BufferType.EDITABLE)
        period_selector.setSelection(period)
    }

    private fun getCheckerTitle(bundle: Bundle?): String {

        if (bundle == null || !bundle.containsKey(TITLE)) return DEFAULT_TITLE

        return bundle.getString(TITLE)
    }

    private fun getCheckerPeriod(bundle: Bundle?): Int {

        if (bundle == null || !bundle.containsKey(PERIOD)) return DEFAULT_PERIOD

        return bundle.getInt(PERIOD)
    }
}