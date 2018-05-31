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
import com.avd.checker.domain.model.time_data.TimeData
import com.avd.checker.ext.getApp
import com.avd.checker.ext.gone
import com.avd.checker.ext.visible
import com.avd.checker.presentation.base.BaseActivity
import com.avd.checker.presentation.presenter.CheckerListPresenter
import com.avd.checker.presentation.view.checker_create.CheckerCreateActivity
import kotlinx.android.synthetic.main.activity_checker_list.*
import javax.inject.Inject
import com.avd.checker.domain.model.time_data.lts
import com.avd.checker.presentation.notification.NotificationHandler
import com.avd.checker.presentation.service.ApplyService
import com.avd.checker.presentation.view.checker_change.CheckerChangeActivity


/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerListActivity : BaseActivity(), CheckerListView {

    @Inject
    lateinit var presenter: CheckerListPresenter

    private lateinit var adapter: CheckerListAdapter

    @Inject
    lateinit var notificationHandler: NotificationHandler

    private var isStarted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Checker"
        getApp().getComponentsHolder()
                .getCheckersComponent()
                .inject(this)
        initPresenter()
        initRecycler()
        initButtons()
        initSwipe()
    }

    override fun getLayoutId() = R.layout.activity_checker_list

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.checker_list_menu, menu)
        return true
    }

    override fun setItems(items: List<CheckerModel>) {
        adapter.setElements(items)
    }

    override fun updateItems(items: List<CheckerModel>) {
        swipe_container.isRefreshing = false
        adapter.update(items)
    }

    override fun hideCreateButton() {
        TransitionManager.beginDelayedTransition(root_layout, Fade())
        create_button.gone()
        floating_create_button.visible()
        recycler.visible()
    }

    override fun showCreateButton() {
        swipe_container.isRefreshing = false
        TransitionManager.beginDelayedTransition(root_layout, Fade())
        recycler.gone()
        floating_create_button.gone()
        create_button.visible()
    }

    override fun onCreateRequest() {

//        notificationHandler.notify(this, CheckerListActivity::class.java,
//                "Test", "TestMsg", R.drawable.ic_settings_white_24dp)

        val intent = Intent(this, CheckerCreateActivity::class.java)
        startActivity(intent)
    }

    override fun onChangeRequest(checker: CheckerModel) {
        val intent = Intent(this, CheckerChangeActivity::class.java)
        val bundle = Bundle()
        bundle.putString(CheckerChangeActivity.TITLE, checker.title)
        bundle.putInt(CheckerChangeActivity.PERIOD,
                getPeriodByTimeInterval(checker.timeData.getType()))
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun onCheckerChanged(checker: CheckerModel) {
        adapter.updateElement(checker)
    }

    override fun onStart() {

        if (isStarted) {
            presenter.onUpdate(lts())
        } else {
            isStarted = true
        }
        super.onStart()
    }

    override fun onStop() {
        startService(Intent(this, ApplyService::class.java))
        super.onStop()
    }

    override fun onDestroy() {
        presenter.onStop()
        presenter.detachView()
        super.onDestroy()
    }

    private fun initPresenter() {
        presenter.attachView(this)
        presenter.onStart(lts())
    }

    private fun initButtons() {
        create_button.setOnClickListener({
            onCreateRequest()
        })

        floating_create_button.setOnClickListener({
            onCreateRequest()
        })
    }

    private fun initSwipe() {
        swipe_container.setColorSchemeResources(R.color.accent)
        swipe_container.setOnRefreshListener { presenter.onUpdate(lts()) }
    }

    private fun initRecycler() {
        adapter = createAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_gray)!!)
        recycler.addItemDecoration(decoration)
        recycler.adapter = adapter
    }

    private fun createAdapter() = CheckerListAdapter(this, object: OnCheckerClickListener {

        override fun onItemClick(item: CheckerModel) {
            presenter.onCheckerClick(item)
        }

        override fun onStateButtonClick(item: CheckerModel) {
            presenter.onStateButtonClick(item)
        }
    })

    private fun getPeriodByTimeInterval(type: Int): Int {
        return when (type) {
            TimeData.MINUTE -> 0
            TimeData.HOUR -> 1
            TimeData.DAY -> 2
            TimeData.WEEK -> 3
            TimeData.MONTH -> 4
            else -> 0
        }
    }
}