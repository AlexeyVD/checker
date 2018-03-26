package com.avd.checker.domain.checker_detail

import com.avd.checker.domain.model.CheckerModel

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

interface CheckerDetailInteractor {
    fun addChecker(title: String, period: String)
}