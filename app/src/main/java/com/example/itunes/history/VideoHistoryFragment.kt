package com.example.itunes.history

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itunes.base.IBaseFragment
import com.example.itunes.callbacks.OnAdapterItemClickListener
import com.example.itunes.data.ItuneDto
import com.example.itunes.data.VideoListAdapter
import com.example.itunes.data.VideoRecyclerViewItem
import com.example.itunes.databinding.FragmentVideoListBinding
import com.example.itunes.db.AppDatabase
import com.example.itunes.info.VideoInfoActivity
import com.example.itunes.network.IResult
import com.example.itunes.ui.hide
import com.example.itunes.ui.show
import com.example.itunes.util.AppConstants
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VideoHistoryFragment : IBaseFragment<FragmentVideoListBinding, VideoHistoryViewModel>(), OnAdapterItemClickListener {

    companion object {

        fun newInstance(): VideoHistoryFragment {
            return VideoHistoryFragment()
        }
    }

    private val videoListAdapter by lazy {
        VideoListAdapter()
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
        binding.videoList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = videoListAdapter
        }
    }

    override fun setupObserver() {
        viewModel.videoHistory.observe(this, Observer {
            when(it) {
                is IResult.Loading -> {
                    binding.videoNetworkLoader.show()
                }
                is IResult.Success -> {
                    binding.videoNetworkLoader.hide()
                    if (it.data != null && it.data.isNotEmpty()) {
                        it.data.forEach {ituneDto ->
                            videoListAdapter.addItem(VideoRecyclerViewItem(ituneDto, this))
                        }
                    } else {
                        binding.noInternetLayout.show()
                        binding.noItemsTitle.text = "No favourite yet"
                        binding.retryButton.hide()
                    }
                }
                is IResult.Error -> {
                    binding.videoNetworkLoader.hide()
                }
            }
        })
    }

    override fun onItemClicked(itemsDto: ItuneDto) {
        val intent = Intent(requireActivity(), VideoInfoActivity::class.java).apply {
            putExtra(AppConstants.VIDEO_DETAIL_INTENT, itemsDto)
        }
        startActivity(intent)
    }
}