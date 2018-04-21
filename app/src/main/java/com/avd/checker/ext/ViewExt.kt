package com.avd.checker.ext

import android.content.Context
import android.os.Build
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_checker_detail.*

/**
 * Created by Aleksey Dementyev on 04.11.2017.
 */

fun View.setBackgroundColorId(colorId: Int) {
    setBackgroundColor(ContextCompat.getColor(context, colorId))
}

fun TextView.setTextColorId(colorId: Int) {
    setTextColor(ContextCompat.getColor(context, colorId))
}

fun Button.setTextColorId(colorId: Int) {
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

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.closeKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}