package com.avd.checker.di.checkers

import com.avd.checker.domain.checker_detail.CheckerDetailInteractor
import com.avd.checker.domain.checker_detail.CheckerDetailInteractorImpl
import com.avd.checker.domain.checker_list.CheckerListInteractor
import com.avd.checker.domain.checker_list.CheckerListInteractorImpl
import com.avd.checker.presentation.presenter.CheckerCreatePresenter
import com.avd.checker.presentation.presenter.CheckerCreatePresenterImpl
import com.avd.checker.presentation.presenter.CheckerListPresenter
import com.avd.checker.presentation.presenter.CheckerListPresenterImpl
import dagger.Binds
import dagger.Module

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@Module
interface CheckersModule {
    @Binds
    @CheckerListScope
    fun provideCheckerListPresenter(presenter: CheckerListPresenterImpl): CheckerListPresenter

    @Binds
    @CheckerListScope
    fun provideCheckerDetailPresenter(presenter: CheckerCreatePresenterImpl): CheckerCreatePresenter

    @Binds
    @CheckerListScope
    fun provideCheckerListInteractor(interactor: CheckerListInteractorImpl): CheckerListInteractor

    @Binds
    @CheckerListScope
    fun provideCheckerDetailInteractor(interactor: CheckerDetailInteractorImpl):
            CheckerDetailInteractor
}