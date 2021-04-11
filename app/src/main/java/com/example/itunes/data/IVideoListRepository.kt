package com.example.itunes.data

import com.example.itunes.network.ApiService
import com.example.itunes.network.IResult
import com.example.itunes.network.performNetworkCall
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow

@ExperimentalCoroutinesApi
class IVideoListRepository(private val apiService: ApiService): VideoListRepository {

    override suspend fun fetchVideoList(): Flow<IResult<ItunesResponseDto>> {
        return performNetworkCall { apiService.fetchVideoList() }
    }

}