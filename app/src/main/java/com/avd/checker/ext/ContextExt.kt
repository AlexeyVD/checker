package com.avd.checker.ext

import android.content.Context
import com.avd.checker.CheckerApp
import android.content.pm.PackageManager
import android.content.pm.PackageInfo
import android.util.Log


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

fun Context.getAppVersion(): String {
    val pInfo: PackageInfo
    try {
        pInfo = packageManager.getPackageInfo(packageName, 0)
        return "v" + pInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        Log.e("ContextExt", e.message)
    }
    return "1.0.0"
}