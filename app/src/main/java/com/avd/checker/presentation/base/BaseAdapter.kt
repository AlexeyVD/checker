package com.avd.checker.presentation.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.avd.checker.domain.model.Model
import com.avd.checker.ext.replaceIf


/**
 * Created by Aleksey Dementyev on 10.10.2017.
 */

abstract class BaseAdapter<T : Model, VH : BaseViewHolder<T>>(val context: Context) :
        RecyclerView.Adapter<VH>() {

    companion object {
        const val NO_ANIMATION = -1
    }

    private val elements = ArrayList<T>()
    private var itemAnimation: Animation? = null
    private var isNewItemInserted = false

    init {
        initAnimation()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val itemView = LayoutInflater.from(parent.context)
                .inflate(getItemLayoutId(), parent, false)
        return getViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(elements[position])
        animateItem(holder.itemView, position)
    }

    override fun getItemCount()= elements.size

    /**
     * Clears elements list and adds all [elements] to adapter
     */
    fun setElements(elements: Collection<T>) {
        if (!this.elements.isEmpty()) this.elements.clear()
        this.elements.addAll(elements)
        notifyDataSetChanged()
    }

    /**
     * Add new [item] to [elements] or replaces it if exists
     */
    fun addElement(item: T) {

        var position = 0

        val iterator = elements.listIterator()

        while (iterator.hasNext()) {
            if (item.id() == iterator.next().id()) {
                iterator.set(item)
                notifyItemChanged(position)
                return
            }
            position++
        }
        iterator.add(item)
        isNewItemInserted = true
        notifyItemInserted(elements.size - 1)
    }

    protected abstract fun getItemLayoutId(): Int

    protected abstract fun getViewHolder(itemView: View): VH

    protected open fun getAnimationId(): Int = NO_ANIMATION

    private fun initAnimation() {
        val animationId = getAnimationId()
        if (animationId == NO_ANIMATION) return
        itemAnimation = AnimationUtils.loadAnimation(context, animationId)
    }

    private fun animateItem(view: View, position: Int) {
        if (itemAnimation == null || position < elements.size - 1)
            return

        if (isNewItemInserted) {
            view.startAnimation(itemAnimation)
            isNewItemInserted = false
        }
    }
}