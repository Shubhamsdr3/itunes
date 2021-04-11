package com.example.itunes.history

import com.example.itunes.data.ItuneDto
import com.example.itunes.db.AppDatabase
import kotlinx.coroutines.flow.Flow

class IVideoHistoryRepository(private val appDatabase: AppDatabase): VideoHistoryRepository {

    override suspend fun fetchVideoHistory(): Flow<List<ItuneDto>> {
         return appDatabase.videoItemDao().fetchVideoHistory()
    }
}