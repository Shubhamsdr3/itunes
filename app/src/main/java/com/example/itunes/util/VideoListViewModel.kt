package com.example.itunes.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.itunes.GetVideosUseCase
import com.example.itunes.base.IBaseViewModel
import com.example.itunes.data.ItuneDto
import com.example.itunes.data.ItunesResponseDto
import com.example.itunes.db.AppDatabase
import com.example.itunes.network.IResult
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class VideoListViewModel(private val getVideosUseCase: GetVideosUseCase, private val appDatabase: AppDatabase): IBaseViewModel() {

    private var _videoList: MutableLiveData<IResult<ItunesResponseDto>> = MutableLiveData()

    val videoList : LiveData<IResult<ItunesResponseDto>> = _videoList

    fun getVideoList() {
        viewModelScope.launch {
            _videoList.postValue(IResult.Loading)
            getVideosUseCase.invoke(Unit).catch {
                _videoList.postValue(IResult.Error(it))
            }.collect {
                _videoList.postValue(it)
            }
        }
    }

    fun saveToDatabase(ituneDto: ItuneDto) {
        viewModelScope.launch {
//            appDatabase.videoItemDao().insertVideoDetail(ituneDto) //FIXME: SHUBHAM
        }
    }
}