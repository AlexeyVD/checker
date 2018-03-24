package com.avd.checker.presentation.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.*
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat

/**
 * Created by Aleksey Dementyev on 04.03.2018.
 */

class NotificationHandler constructor(val manager: NotificationManager) {

    companion object {
        val CHANNEL_ID = "checker_channel_1"
        val CHANNEL_NAME = "checker_channel"

        fun channel(): NotificationChannel? {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                return NotificationChannel(CHANNEL_ID, CHANNEL_NAME, IMPORTANCE_DEFAULT)
            }
            return null
        }
    }

    init {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            manager.createNotificationChannel(channel())
        }
    }

    fun notify(context: Context, clazz: Class<*>, title: String, message: String, icon: Int) {
        val resultIntent = Intent(context, clazz)
        val resultPendingIntent = PendingIntent.getActivity(
                context,
                0,
                resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT)

        val mBuilder = NotificationCompat.Builder(
                context.applicationContext, CHANNEL_ID).setSmallIcon(icon)
                .setContentTitle(title)
                .setContentText(message)
                .setContentIntent(resultPendingIntent)
                .setChannelId(CHANNEL_ID)

        manager.notify(1, mBuilder.build())
    }
}