package com.example.myapplicationnotifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getDataString();
        Log.d("NotificationReceiver", "onReceive: text " + text);
    }
}
