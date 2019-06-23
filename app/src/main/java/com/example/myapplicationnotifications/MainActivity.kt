package com.example.myapplicationnotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val notificationManager = MyNotificationManager()
        notificationManager.createNotificationChannel(this)
        notificationManager.createNotifiation(this, "xxxx", "aaa", "aaa")
        notificationManager.createNotifiation(this, "xxxx", "bbb", "bbb")
    }
}
