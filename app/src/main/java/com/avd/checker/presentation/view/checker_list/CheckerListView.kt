package com.avd.checker.presentation.view.checker_list

import com.avd.checker.domain.model.CheckerModel

/**
 * Created by Aleksey Dementyev on 07.11.2017.
 */

interface CheckerListView {

    /**
     * Sets items to screen
     */
    fun setItems(items: List<CheckerModel>)

    /**
     * Updates items list on screen
     */
    fun updateItems(items: List<CheckerModel>)

    fun hideCreateButton()


    fun showCreateButton()

    fun onCreateRequest()

    fun onChangeRequest(checker: CheckerModel)

    fun onCheckerChanged(checker: CheckerModel)

    fun onSettingsButtonPressed()
}