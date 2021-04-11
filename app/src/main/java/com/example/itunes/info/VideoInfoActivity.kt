package com.example.itunes.info

import android.os.Bundle
import com.example.itunes.base.IBaseActivity
import com.example.itunes.data.ItuneDto
import com.example.itunes.util.AppConstants.VIDEO_DETAIL_INTENT
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VideoInfoActivity: IBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (intent.hasExtra(VIDEO_DETAIL_INTENT)) {
            val videoDetail = intent.extras?.get(VIDEO_DETAIL_INTENT) as ItuneDto
            startFragment(VideoInfoFragment.newInstance(videoDetail), false)
        }
    }
}