package com.example.itunes.services

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class TestJobService: JobService() {

    override fun onStopJob(params: JobParameters?): Boolean {
        val service = Intent(this, NetworkJobService::class.java)
        startService(service)
        NetworkChangeScheduler.scheduleJob(this)
        return true
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        return true
    }
}