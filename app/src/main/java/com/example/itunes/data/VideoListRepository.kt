package com.example.itunes.data

import com.example.itunes.network.IResult
import kotlinx.coroutines.flow.Flow

interface VideoListRepository {

    suspend fun fetchVideoList(): Flow<IResult<ItunesResponseDto>>
}