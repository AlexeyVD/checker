package com.avd.checker.presentation.view.checker_list

import com.avd.checker.domain.model.CheckerModel

interface OnCheckerClickListener {

    fun onItemClick(item: CheckerModel)
    fun onStateButtonClick(item: CheckerModel)
}