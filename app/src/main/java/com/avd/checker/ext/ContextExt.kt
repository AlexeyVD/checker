package com.avd.checker.ext

import android.content.Context
import com.avd.checker.CheckerApp

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

fun Context.getApp() = applicationContext as CheckerApp

fun Context.getStringArrayItem(id: Int, itemId: Int) = resources.getStringArray(id)[itemId]

/**
 * @return value from string resources by [key]
 */
fun Context.getStringByKey(key: String): String {
    val id = resources.getIdentifier(key, "string", packageName)
    if (id == 0) return key
    return getString(id)
}