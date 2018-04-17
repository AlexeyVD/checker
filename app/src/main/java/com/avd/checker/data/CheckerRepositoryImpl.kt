package com.avd.checker.data

import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.repository.CheckerRepository
import io.reactivex.*
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

@Singleton
class CheckerRepositoryImpl @Inject constructor(val dataSource: DataSource<CheckerModel>) :
        CheckerRepository {

    private var mEmitter: FlowableEmitter<CheckerModel>? = null

    override fun getCheckers(): Single<List<CheckerModel>> = dataSource.getAll()

    override fun putChecker(checker: CheckerModel): Completable {
        return dataSource.put(checker)
                .doOnSuccess(this::notifyCheckerChanged)
                .toCompletable()
    }

    override fun subscribeCheckers(): Flowable<CheckerModel> {
        return Flowable.create({ mEmitter = it }, BackpressureStrategy.DROP)
    }

    override fun unsubscribeCheckers() {
        mEmitter?.onComplete()
        mEmitter = null
    }

    private fun notifyCheckerChanged(checker: CheckerModel) {
        mEmitter?.onNext(checker)
    }
}