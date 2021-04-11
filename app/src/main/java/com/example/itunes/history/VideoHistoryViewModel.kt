package com.example.itunes.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.itunes.base.IBaseViewModel
import com.example.itunes.data.ItuneDto
import com.example.itunes.network.IResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class VideoHistoryViewModel(private val getVideoHistoryUseCase: GetVideoHistoryUseCase): IBaseViewModel() {

    private var _videoHistory: MutableLiveData<IResult<List<ItuneDto>>> = MutableLiveData()

    val videoHistory: LiveData<IResult<List<ItuneDto>>> = _videoHistory

    fun fetchVideoHistory() {
        viewModelScope.launch {
            _videoHistory.postValue(IResult.Loading)
            getVideoHistoryUseCase.invoke(Unit)
                .catch {
                    _videoHistory.postValue(IResult.Error(it))
                }.collect {
                    _videoHistory.postValue(IResult.Success(it))
                }
        }
    }
}