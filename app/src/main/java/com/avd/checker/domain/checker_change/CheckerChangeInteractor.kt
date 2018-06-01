package com.avd.checker.domain.checker_change

import com.avd.checker.domain.model.CheckerDto

interface CheckerChangeInteractor {

    /**
     * @return [CheckerDto]
     */
    fun get(): CheckerDto

    /**
     * Applies changes
     */
    fun apply(title: String, timeDataType: Int, isChecked: Boolean)

    /**
     * Deletes checker
     */
    fun delete()
}