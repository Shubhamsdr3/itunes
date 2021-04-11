package com.example.itunes.history

import com.example.itunes.data.ItuneDto
import kotlinx.coroutines.flow.Flow

interface VideoHistoryRepository {

    suspend fun fetchVideoHistory(): Flow<List<ItuneDto>>
}