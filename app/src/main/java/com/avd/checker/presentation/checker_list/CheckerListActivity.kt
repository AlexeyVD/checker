package com.avd.checker.presentation.checker_list

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.avd.checker.R
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_checker_list.*


/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

class CheckerListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
    }

    override fun getLayoutId() = R.layout.activity_checker_list

    private fun initRecycler() {
        val adapter = CheckerListAdapter()
        recycler.layoutManager = LinearLayoutManager(this)
        val decoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        decoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_gray))
        recycler.addItemDecoration(decoration)
        recycler.adapter = adapter

        val items = ArrayList<CheckerModel>()

        items.add(CheckerModel("Заплатить налоги", "1д", false))
        items.add(CheckerModel("Погулять с собакой", "1д", false))
        items.add(CheckerModel("Купить слона", "1д", false))
        items.add(CheckerModel("Продать слона", "1д", false))
        items.add(CheckerModel("Погладить кота", "", false))

        adapter.setElements(items)
        adapter.notifyDataSetChanged()
    }
}