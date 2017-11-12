package com.avd.checker.presentation.base

import android.R
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import android.view.animation.Animation
import android.view.animation.AnimationUtils


/**
 * Created by Aleksey Dementyev on 10.10.2017.
 */

abstract class BaseAdapter<T, VH : BaseViewHolder<T>>(val context: Context) :
        RecyclerView.Adapter<VH>() {

    private val mElements = ArrayList<T>()
    private var itemAnimation: Animation? = null

    init {
        initAnimation()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val itemView = LayoutInflater.from(parent.context)
                .inflate(getItemLayoutId(), parent, false)
        return getViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(mElements[position])
        animateItem(holder.itemView, position)
    }

    override fun getItemCount()= mElements.size

    fun setElements(elements: Collection<T>) {
        mElements.addAll(elements)
        notifyDataSetChanged()
    }

    fun addElement(item: T) {
        mElements.add(item)
        notifyItemInserted(mElements.size - 1)
    }

    protected abstract fun getItemLayoutId(): Int

    protected abstract fun getViewHolder(itemView: View): VH

    protected open fun getAnimationId(): Int = -1

    private fun initAnimation() {
        val animationId = getAnimationId()
        if (animationId == -1) return
        itemAnimation = AnimationUtils.loadAnimation(context, animationId)
    }

    private fun animateItem(view: View, position: Int) {
        if (itemAnimation == null || position < mElements.size - 1)
            return
        view.startAnimation(itemAnimation)
    }
}