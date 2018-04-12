package com.avd.checker.data

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Single

interface DataSource {

    /**
     * @return Single with list of existing [CheckerModel] checkers
     */
    fun getCheckers(): Single<List<CheckerModel>>
}