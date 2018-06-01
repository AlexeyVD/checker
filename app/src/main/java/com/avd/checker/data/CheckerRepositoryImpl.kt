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

    override fun generateId() = dataSource.generateId()

    override fun getAll() = dataSource.getAll()

    override fun create(checker: CheckerModel) {
        dataSource.put(checker)
    }

    override fun put(checker: CheckerModel) {
        dataSource.put(checker)
    }

    override fun delete(id: Long) {
        dataSource.remove(id)
    }

    override fun init() = dataSource.init()

    override fun apply() {
        dataSource.apply()
    }
}