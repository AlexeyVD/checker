package com.avd.checker.di.checkers

import com.avd.checker.presentation.view.checker_change.CheckerChangeActivity
import dagger.Subcomponent

@Subcomponent(modules = [(CheckerChangeModule::class)])
@CheckerListScope
interface CheckerChangeComponent {

    @Subcomponent.Builder
    interface Builder {
        fun checkerChangeModule(checkerChangeModule: CheckerChangeModule): Builder
        fun build(): CheckerChangeComponent
    }

    fun inject(checkerChangeActivity: CheckerChangeActivity)
}