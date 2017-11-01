package com.avd.kotlin_rss.presentation.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.util.ArrayList

/**
 * Created by Aleksey Dementyev on 10.10.2017.
 */

abstract class BaseAdapter<T, VH : BaseViewHolder<T>> : RecyclerView.Adapter<VH>() {

    private val mElements = ArrayList<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {

        val itemView = LayoutInflater.from(parent.context)
                .inflate(getItemLayoutId(), parent, false)
        return getViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(mElements[position])
    }

    override fun getItemCount()= mElements.size

    fun setElements(elements: Collection<T>) {
        mElements.addAll(elements)
    }

    protected abstract fun getItemLayoutId(): Int

    protected abstract fun getViewHolder(itemView: View): VH
}