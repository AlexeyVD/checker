package com.avd.checker.ext

import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.TextView

/**
 * Created by Aleksey Dementyev on 04.11.2017.
 */

fun View.setBackgroundColorId(colorId: Int) {
    setBackgroundColor(ContextCompat.getColor(context, colorId))
}

fun TextView.setTextColorId(colorId: Int) {
    setTextColor(ContextCompat.getColor(context, colorId))
}

fun View.setBackgroundDrawableId(drawableId: Int) {
    val drawable = ContextCompat.getDrawable(context, drawableId)
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        background = drawable
    } else {
        setBackgroundDrawable(drawable)
    }
}