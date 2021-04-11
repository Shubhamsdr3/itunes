package com.example.itunes.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class VideoHistoryViewModelFactory(private val getVideoHistoryUseCase: GetVideoHistoryUseCase): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VideoHistoryViewModel::class.java)) {
            return VideoHistoryViewModel(getVideoHistoryUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}