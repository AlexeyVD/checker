package com.avd.checker.data

import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.FlowableEmitter
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@Singleton
class CheckerRepositoryImpl @Inject constructor(val dataSource: DataSource<CheckerModel>) :
        CheckerRepository {

    private var mEmitter: FlowableEmitter<CheckerModel>? = null

    override fun generateId() = 1

    override fun getCheckers(): Single<List<CheckerModel>> = dataSource.getAll()

    override fun addChecker(checker: CheckerModel) {
        dataSource.put(checker)
        mEmitter?.onNext(checker)
    }

    override fun updateChecker(checker: CheckerModel) {
        dataSource.put(checker)
    }

    override fun subscribeCheckers(): Flowable<CheckerModel> {
        return Flowable.create({ mEmitter = it }, BackpressureStrategy.DROP)
    }

    override fun unsubscribeCheckers() {
        mEmitter?.onComplete()
        mEmitter = null
    }
}