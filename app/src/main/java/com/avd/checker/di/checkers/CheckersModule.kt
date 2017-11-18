package com.avd.checker.di.checkers

import com.avd.checker.domain.checker_detail.CheckerDetailInteractor
import com.avd.checker.domain.checker_detail.CheckerDetailInteractorImpl
import com.avd.checker.domain.checker_list.CheckerListInteractor
import com.avd.checker.domain.checker_list.CheckerListInteractorImpl
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.BaseAdapter
import com.avd.checker.presentation.checker_list.CheckerListAdapter
import com.avd.checker.presentation.checker_list.CheckerViewHolder
import com.avd.checker.presentation.presenter.CheckerDetailPresenter
import com.avd.checker.presentation.presenter.CheckerDetailPresenterImpl
import com.avd.checker.presentation.presenter.CheckerListPresenter
import com.avd.checker.presentation.presenter.CheckerListPresenterImpl
import dagger.Binds
import dagger.Module
import dagger.Provides

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
    fun provideCheckerDetailPresenter(presenter: CheckerDetailPresenterImpl): CheckerDetailPresenter

    @Binds
    @CheckerListScope
    fun provideBaseAdapter(adapter: CheckerListAdapter): BaseAdapter<CheckerModel, CheckerViewHolder>

    @Binds
    @CheckerListScope
    fun provideCheckerListInteractor(interactor: CheckerListInteractorImpl): CheckerListInteractor

    @Binds
    @CheckerListScope
    fun provideCheckerDetailInteractor(interactor: CheckerDetailInteractorImpl):
            CheckerDetailInteractor
}