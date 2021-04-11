package com.example.itunes.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.itunes.base.IBaseViewModel
import com.example.itunes.data.ItuneDto

class VideoInfoViewModel : IBaseViewModel() {

    private var _videoDetail: MutableLiveData<ItuneDto> = MutableLiveData()

    val videoDetail: LiveData<ItuneDto> = _videoDetail

    fun postVideoDetail(ituneDto: ItuneDto) {
        _videoDetail.postValue(ituneDto)
    }
}