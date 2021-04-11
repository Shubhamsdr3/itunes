package com.example.itunes.history

import android.view.LayoutInflater
import androidx.lifecycle.Observer
import com.example.itunes.base.IBaseFragment
import com.example.itunes.databinding.FragmentVideoListBinding
import com.example.itunes.db.AppDatabase
import com.example.itunes.network.IResult
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VideoHistoryFragment : IBaseFragment<FragmentVideoListBinding, VideoHistoryViewModel>() {

    companion object {

        fun newInstance(): VideoHistoryFragment {
            return VideoHistoryFragment()
        }
    }

    private val videoHistoryRepository by lazy {
        IVideoHistoryRepository(AppDatabase.getAppDatabase(requireContext()))
    }

    override val viewModel: VideoHistoryViewModel by lazy {
        VideoHistoryViewModel(GetVideoHistoryUseCase(videoHistoryRepository))
    }

    override fun getViewBinding(inflater: LayoutInflater): FragmentVideoListBinding {
        return FragmentVideoListBinding.inflate(inflater)
    }

    override fun setupView() {
        viewModel.fetchVideoHistory()
    }

    override fun setupObserver() {
        viewModel.videoHistory.observe(this, Observer {
            when(it) {
                is IResult.Loading -> {

                }
                is IResult.Success -> {

                }
                is IResult.Error -> {

                }
            }
        })
    }
}