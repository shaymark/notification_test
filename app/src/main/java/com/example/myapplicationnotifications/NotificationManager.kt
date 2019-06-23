package com.example.myapplicationnotifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.ClipData
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import android.R.attr.scheme
import android.net.Uri
import androidx.core.app.NotificationManagerCompat


class MyNotificationManager {

    companion object {
        const val CHANNEL_ID = "2"
        const val CHANEL_NAME = "AAA"
        const val CHANEL_DESCRIPTION = "SSSS"
        const val REQUEST_CODE = 44
    }

    var notificationId = 99

    fun createNotifiation(context: Context, textTitle: String, textContent: String, textIntent: String) {
        var builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.notification_icon_background)
            .setContentTitle(textTitle)
            .setContentText(textContent)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(createIntent(context, textIntent))
            .setDeleteIntent(createIntent(context, textIntent))
            .setAutoCancel(true)

        notificationId = notificationId + 1
        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }
    }

    private fun createIntent(context: Context, text: String): PendingIntent{
        // Create an explicit intent for an Activity in your app
        var intent = Intent(context, NotificationReceiver::class.java)
        intent.data = Uri.Builder().scheme("data")
            .appendQueryParameter("text", text).build()
        return PendingIntent.getBroadcast(context, REQUEST_CODE, intent, 0)
    }

    fun createNotificationChannel(context: Context) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = CHANEL_NAME
            val descriptionText = CHANEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Register the channel with the system
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }





}
