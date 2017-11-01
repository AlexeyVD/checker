package com.avd.kotlin_rss.presentation.base

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by Aleksey Dementyev on 10.10.2017.
 */

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    abstract fun bind(item: T)
}