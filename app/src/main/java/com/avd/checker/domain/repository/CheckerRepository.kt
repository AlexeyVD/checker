package com.avd.checker.domain.repository

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

interface CheckerRepository {

    /**
     * @return next id
     */
    fun generateId(): Long

    /**
     * @return list of existing [CheckerModel] checkers
     */
    fun getAll(): List<CheckerModel>

    /**
     * Creates new checker
     */
    fun create(checker: CheckerModel)

    /**
     * Puts checker to repository or replaces it if exists
     */
    fun put(checker: CheckerModel)

    /**
     * Deletes checker from repository by [id]
     */
    fun delete(id: Long)

    /**
     * Init data source
     */
    fun init(): Completable

    /**
     * Applies changes in data source
     */
    fun apply()
}