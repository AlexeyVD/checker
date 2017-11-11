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
class CheckerRepositoryImpl @Inject constructor() : CheckerRepository {

    private val mCheckers = ArrayList<CheckerModel>()
    private var mEmitter: FlowableEmitter<CheckerModel>? = null

    override fun getCheckers(): Single<List<CheckerModel>> = Single.just(ArrayList(mCheckers))

    override fun addChecker(checker: CheckerModel) {
        mCheckers.add(checker)
        mEmitter?.onNext(checker)
    }

    override fun subscribeCheckers(): Flowable<CheckerModel> {
        return Flowable.create({ mEmitter = it }, BackpressureStrategy.DROP)
    }

    override fun unsubscribeCheckers() {
        mEmitter?.onComplete()
        mEmitter = null
    }
}