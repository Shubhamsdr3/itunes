package com.example.itunes

import com.example.itunes.base.IBaseUseCase
import com.example.itunes.data.ItunesResponseDto
import com.example.itunes.data.VideoListRepository
import com.example.itunes.network.IResult
import kotlinx.coroutines.flow.Flow

class GetVideosUseCase(private val videoListRepository: VideoListRepository) : IBaseUseCase<Unit, ItunesResponseDto> {

    override suspend fun invoke(input: Unit): Flow<IResult<ItunesResponseDto>> {
        return videoListRepository.fetchVideoList()
    }
}