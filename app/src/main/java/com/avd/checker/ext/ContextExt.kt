package com.avd.checker.ext

import android.content.Context
import com.avd.checker.CheckerApp

/**
 * Created by Aleksey Dementyev on 11.11.2017.
 */

fun Context.getApp() = applicationContext as CheckerApp

fun Context.getStringArrayItem(id: Int, itemId: Int) = resources.getStringArray(id)[itemId]