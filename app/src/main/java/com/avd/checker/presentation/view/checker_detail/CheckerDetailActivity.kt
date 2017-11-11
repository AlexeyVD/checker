package com.avd.checker.presentation.view.checker_detail

import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import com.avd.checker.R
import com.avd.checker.ext.closeKeyboard
import com.avd.checker.ext.getApp
import com.avd.checker.ext.getStringArrayItem
import com.avd.checker.presentation.base.BaseActivity
import com.avd.checker.presentation.presenter.CheckerDetailPresenter
import kotlinx.android.synthetic.main.activity_checker_detail.*
import javax.inject.Inject


/**
 * Created by Aleksey Dementyev on 08.11.2017.
 */

class CheckerDetailActivity : BaseActivity(), CheckerDetailView {

    @Inject
    lateinit var presenter: CheckerDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar_detail)
        supportActionBar?.let { initToolbar(it) }
        getApp().getComponentsHolder()
                .getCheckersComponent()
                .inject(this)
        initInputs()
        initPresenter()
    }

    private fun initPresenter() {
        presenter.attachView(this)
    }

    private fun initToolbar(actionBar: ActionBar) {
        actionBar.title = "Создать чекер"
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
    }

    private fun initInputs() {
        title_input.setOnEditorActionListener({ _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                title_input.clearFocus()
                title_input.closeKeyboard()
                true
            } else {
                false
            }
        })
    }

    override fun getLayoutId() = R.layout.activity_checker_detail

    override fun close() {
        presenter.detachView()
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.checker_detail_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_check -> {
                presenter.createChecker(title_input.text.toString(),
                        getStringArrayItem(R.array.periods, period_selector.selectedItemId.toInt()))
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return  true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}