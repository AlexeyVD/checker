package com.avd.checker.presentation.checker_list

import android.content.Context
import android.view.View
import com.avd.checker.R
import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.BaseAdapter
import javax.inject.Inject
import android.view.animation.AnimationUtils
import android.view.animation.Animation
import android.view.animation.AnimationUtils.loadAnimation


/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

@CheckerListScope
class CheckerListAdapter @Inject constructor(context: Context) : BaseAdapter<CheckerModel,
        CheckerViewHolder>(context) {

    override fun getItemLayoutId() = R.layout.item_checker_list

    override fun getViewHolder(itemView: View) = CheckerViewHolder(itemView)

    override fun getAnimationId() = R.anim.item_fall_down_anim



}