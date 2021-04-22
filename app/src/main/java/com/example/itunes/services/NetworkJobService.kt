package com.example.itunes.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class NetworkJobService: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        NetworkChangeScheduler.scheduleJob(context)
    }
}