package com.avd.checker.di.checkers

import com.avd.checker.presentation.service.ApplyService
import com.avd.checker.presentation.view.checker_list.CheckerListActivity
import com.avd.checker.presentation.view.checker_detail.CheckerDetailActivity
import dagger.Subcomponent

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@Subcomponent(modules = arrayOf(CheckersModule::class))
@CheckerListScope
interface CheckersComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): CheckersComponent
    }

    fun inject(checkerListActivity: CheckerListActivity)
    fun inject(checkerDetailActivity: CheckerDetailActivity)
    fun inject(applyService: ApplyService)
}