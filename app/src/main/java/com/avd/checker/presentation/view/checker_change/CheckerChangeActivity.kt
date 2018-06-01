package com.avd.checker.presentation.view.checker_change

import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AlertDialog
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import com.avd.checker.R
import com.avd.checker.domain.model.CheckerDto
import com.avd.checker.domain.model.time_data.getSelectionId
import com.avd.checker.domain.model.time_data.getTimeDataBySelection
import com.avd.checker.ext.closeKeyboard
import com.avd.checker.ext.getApp
import com.avd.checker.presentation.base.BaseActivity
import com.avd.checker.presentation.presenter.CheckerChangePresenter
import kotlinx.android.synthetic.main.activity_checker_change.*
import javax.inject.Inject

class CheckerChangeActivity : BaseActivity(), CheckerChangeView {

    companion object {
        const val CHECKER = "checker"
        val DEFAULT_CHECKER = CheckerDto(0, "", 1, false)
    }

    @Inject
    lateinit var presenter: CheckerChangePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getApp().getComponentsHolder()
                .getCheckerChangeComponent(getChecker(intent.extras))
                .inject(this)

        setSupportActionBar(toolbar_detail)
        supportActionBar?.let { initToolbar(it) }

        initPresenter()
        initButtons()
        initInputs()
    }

    override fun getLayoutId() = R.layout.activity_checker_change

    override fun setData(checker: CheckerDto) {
        title_input.setText(checker.title, TextView.BufferType.EDITABLE)
        period_selector.setSelection(getSelectionId(checker.timeDataTypeId))
        state_check_box.isChecked = checker.isChecked
    }

    override fun showDeleteDialog() {
        AlertDialog.Builder(this)
                .setMessage(getString(R.string.apply_delete))
                .setPositiveButton(getString(R.string.delete_upper),
                        { _, _ -> presenter.delete() })
                .setNegativeButton(getString(R.string.cancel_upper), { _, _ ->  })
                .create()
                .show()
    }

    override fun onDeleteEvent() {
        finish()
    }

    override fun onBackPressed() {
        apply()
        super.onBackPressed()
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun initToolbar(actionBar: ActionBar) {
        actionBar.title = getString(R.string.edit_checker)
        actionBar.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)
    }

    private fun initPresenter() {
        presenter.attachView(this)
        presenter.onStart()
    }

    private fun initButtons() {
        delete_button.setOnClickListener {
            presenter.onDeleteButtonClick()
        }
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

    private fun apply() {
        presenter.apply(title_input.text.toString(),
                getTimeDataBySelection(period_selector.selectedItemId.toInt()),
                state_check_box.isChecked)
    }

    private fun getChecker(bundle: Bundle?): CheckerDto {
        if (bundle == null || !bundle.containsKey(CHECKER)) return DEFAULT_CHECKER

        return bundle.getParcelable(CHECKER)
    }
}