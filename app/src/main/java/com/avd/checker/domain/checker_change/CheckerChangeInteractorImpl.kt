package com.avd.checker.domain.checker_change

import com.avd.checker.data.toModel
import com.avd.checker.domain.model.CheckerDto
import com.avd.checker.domain.repository.CheckerRepository

class CheckerChangeInteractorImpl(private val repository: CheckerRepository,
                                  private var checker: CheckerDto) : CheckerChangeInteractor {
    override fun get() = checker

    override fun apply(title: String, timeDataType: Int, isChecked: Boolean) {
        if (isChanged(title, timeDataType, isChecked)) {
            checker = CheckerDto(checker.id, title, timeDataType, isChecked)
            repository.put(checker.toModel())
        }
    }

    override fun delete() {
        repository.delete(checker.id)
    }

    private fun isChanged(title: String, timeDataType: Int, isChecked: Boolean)
            = checker.title != title
            || checker.timeDataTypeId != timeDataType
            || checker.isChecked != isChecked
}