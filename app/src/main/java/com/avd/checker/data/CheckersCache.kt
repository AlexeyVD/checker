package com.avd.checker.data

import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.domain.model.time_data.lts

class CheckersCache {

    private var updateLts:Long = 0
    private val checkers = HashMap<Long, CheckerModel>()

    /**
     * Add all [checkers] to cache
     */
    fun putAll(checkers: List<CheckerModel>) {
        checkers.forEach { this.checkers[it.id] = it }
        updateLts()
    }

    /**
     * Add [checker] to cache
     */
    fun put(checker: CheckerModel) {
        checkers[checker.id] = checker
        updateLts()
    }

    /**
     * @return list of all checkers from cache
     */
    fun getAll(): List<CheckerModel> = ArrayList(checkers.values)

    /**
     * @return checker from cache by [id]
     */
    fun get(id: Long) = checkers[id]

    /**
     * Remove all elements from cache
     */
    fun removeAll() {
        checkers.clear()
        updateLts()
    }

    /**
     * Remove checker from cache by [id]
     */
    fun remove(id: Long) {
        checkers.remove(id)
        updateLts()
    }

    /**
     * @return true if data in cache is expired or false otherwise
     */
    fun isExpired() = updateLts == 0L

    private fun updateLts() {
        updateLts = lts()
    }
}