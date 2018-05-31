package com.avd.checker.presentation.view.checker_list

import android.content.Context
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.AnimationUtils.loadAnimation
import com.avd.checker.R
import com.avd.checker.di.checkers.CheckerListScope
import com.avd.checker.domain.model.CheckerModel
import com.avd.checker.presentation.base.BaseAdapter
import javax.inject.Inject


/**
 * Created by Aleksey Dementyev on 02.11.2017.
 */

@CheckerListScope
class CheckerListAdapter (context: Context, private val listener: OnCheckerClickListener) :
        BaseAdapter<CheckerModel, CheckerViewHolder>(context) {

    companion object {
        const val NO_ITEM = -1L
    }

    private val itemAnimation: Animation = loadAnimation(context, R.anim.item_fall_down_anim)
    private var itemIdToAnimate = NO_ITEM

    override fun getItemLayoutId() = R.layout.item_checker_list

    override fun getViewHolder(itemView: View) = CheckerViewHolder(itemView, listener)

    override fun onBindViewHolder(holder: CheckerViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        animateItem(holder.itemView, position)
    }

    fun update(items: Collection<CheckerModel>) {
        if (items.size > elements.size) {
            for (item in items) {
                if (item.isChecked) {
                    break
                } else {
                    itemIdToAnimate = item.id
                }
            }
        }
        setElements(items)
    }

    private fun animateItem(view: View, position: Int) {
        if (itemIdToAnimate == NO_ITEM) return

        if (itemIdToAnimate == elements[position].id) {
            view.startAnimation(itemAnimation)
            itemIdToAnimate = NO_ITEM
        }
    }
}