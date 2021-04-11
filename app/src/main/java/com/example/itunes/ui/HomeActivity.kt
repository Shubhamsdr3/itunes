package com.example.itunes.ui

import android.os.Bundle
import com.example.itunes.R
import com.example.itunes.base.IBaseActivity
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class HomeActivity : IBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        startFragment(DashboardFragment.newInstance(), false)
    }
}