package com.avd.checker.domain.checker_detail

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Completable

/**
 * Created by Aleksey Dementyev on 18.11.2017.
 */

interface CheckerDetailInteractor {

    /**
     * Creates new checker
     */
    fun createChecker(title: String, period: Int)
}