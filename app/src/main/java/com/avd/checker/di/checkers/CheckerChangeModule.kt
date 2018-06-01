package com.avd.checker.di.checkers

import com.avd.checker.domain.checker_change.CheckerChangeInteractor
import com.avd.checker.domain.checker_change.CheckerChangeInteractorImpl
import com.avd.checker.domain.model.CheckerDto
import com.avd.checker.domain.repository.CheckerRepository
import com.avd.checker.presentation.presenter.CheckerChangePresenter
import com.avd.checker.presentation.presenter.CheckerChangePresenterImpl
import dagger.Module
import dagger.Provides

@Module
class CheckerChangeModule(val checker: CheckerDto) {

    @CheckerListScope
    @Provides
    fun provideCheckerChangeInteractor(repository: CheckerRepository): CheckerChangeInteractor
            = CheckerChangeInteractorImpl(repository, checker)
    @CheckerListScope
    @Provides
    fun provideCheckerChangePresenter(interactor: CheckerChangeInteractor): CheckerChangePresenter
            = CheckerChangePresenterImpl(interactor)
}