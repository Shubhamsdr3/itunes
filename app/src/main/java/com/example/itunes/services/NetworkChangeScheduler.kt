package com.example.itunes.services

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

object NetworkChangeScheduler {

    private const val NETWORK_CHANGE = 0

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun scheduleJob(context: Context?) {
        val jobScheduler: JobScheduler = context?.getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler
        val jobInfo = JobInfo.Builder(
            NETWORK_CHANGE,
            ComponentName(
                context,
                NetworkJobService::class.java
            )).setRequiredNetworkType(
            JobInfo.NETWORK_TYPE_UNMETERED
        ).setRequiresCharging(true).build()
        jobScheduler.schedule(jobInfo)
    }
}