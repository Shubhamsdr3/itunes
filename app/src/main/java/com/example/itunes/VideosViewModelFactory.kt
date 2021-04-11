package com.example.itunes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.itunes.db.AppDatabase
import com.example.itunes.util.VideoListViewModel

class VideosViewModelFactory(private val getVideosUseCase: GetVideosUseCase, private val appDatabase: AppDatabase) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoListViewModel::class.java)) {
            return VideoListViewModel(getVideosUseCase, appDatabase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}