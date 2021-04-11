package com.example.itunes.history

import com.example.itunes.base.ILocalUseCase
import com.example.itunes.data.ItuneDto
import kotlinx.coroutines.flow.Flow

class GetVideoHistoryUseCase(private val videoHistoryRepository: IVideoHistoryRepository) : ILocalUseCase<Unit, List<ItuneDto>> {

    override suspend fun invoke(input: Unit): Flow<List<ItuneDto>> {
        return videoHistoryRepository.fetchVideoHistory()
    }

}