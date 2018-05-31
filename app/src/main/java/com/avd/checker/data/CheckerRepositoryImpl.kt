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

    override fun generateId() = dataSource.generateId()

    override fun getCheckers() = dataSource.getAll()

    override fun createChecker(checker: CheckerModel) {
        dataSource.put(checker)
    }

    override fun putChecker(checker: CheckerModel) {
        dataSource.put(checker)
    }

    override fun init() = dataSource.init()

    override fun apply() {
        dataSource.apply()
    }
}