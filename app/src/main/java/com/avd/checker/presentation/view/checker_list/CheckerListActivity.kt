package com.avd.checker.presentation.view.checker_list

import android.content.Intent
import android.os.Bundle
import android.support.transition.Fade
import android.support.transition.TransitionManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import com.avd.checker.R
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.ext.getApp
import com.avd.checker.ext.gone
import com.avd.checker.ext.visible
import com.avd.checker.presentation.base.BaseActivity
import com.avd.checker.presentation.base.BaseAdapter
import com.avd.checker.presentation.presenter.CheckerListPresenter
import com.avd.checker.presentation.view.checker_detail.CheckerDetailActivity
import kotlinx.android.synthetic.main.activity_checker_list.*
import javax.inject.Inject
import com.avd.checker.ext.lts
import com.avd.checker.presentation.notification.NotificationHandler


/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerListActivity : BaseActivity(), CheckerListView {

    @Inject
    lateinit var presenter: CheckerListPresenter

    @Inject
    lateinit var adapter: BaseAdapter<CheckerModel, CheckerViewHolder>

    @Inject
    lateinit var notificationHandler: NotificationHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Checker"
        getApp().getComponentsHolder()
                .getCheckersComponent()
                .inject(this)
        initRecycler()
        initButtons()
        initPresenter()
    }

    override fun getLayoutId() = R.layout.activity_checker_list

    private fun initPresenter() {
        presenter.attachView(this)
        presenter.onStart(lts())
    }

    private fun initButtons() {
        create_button.setOnClickListener({
            openDetailActivity()
        })

        floating_create_button.setOnClickListener({
            openDetailActivity()
//            addItem(CheckerModel("Заплатить налоги", "Осталось: 1 ч 25 мин",
//                    false))
        })
    }

    private fun initRecycler() {
        recycler.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_gray)!!)
        recycler.addItemDecoration(decoration)
        recycler.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.checker_list_menu, menu)
        return true
    }

    override fun setItems(items: List<CheckerModel>) {
        adapter.setElements(items)
    }

    override fun addItem(item: CheckerModel) {
        adapter.addElement(item)
    }

    override fun hideCreateButton() {
        TransitionManager.beginDelayedTransition(root_layout, Fade())
        create_button.gone()
        floating_create_button.visible()
        recycler.visible()
    }

    override fun showCreateButton() {
        TransitionManager.beginDelayedTransition(root_layout, Fade())
        recycler.gone()
        floating_create_button.gone()
        create_button.visible()
    }

    override fun openDetailActivity() {

        notificationHandler.notify(this, CheckerListActivity::class.java,
                "Test", "TestMsg", R.drawable.ic_settings_white_24dp)

        val intent = Intent(this, CheckerDetailActivity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onStop()
        presenter.detachView()
    }
}