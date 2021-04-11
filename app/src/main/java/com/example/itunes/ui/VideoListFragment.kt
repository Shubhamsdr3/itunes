package com.example.itunes.ui

import android.content.Intent
import android.graphics.Rect
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itunes.App
import com.example.itunes.GetVideosUseCase
import com.example.itunes.VideosViewModelFactory
import com.example.itunes.base.IBaseFragment
import com.example.itunes.callbacks.OnAdapterItemClickListener
import com.example.itunes.data.IVideoListRepository
import com.example.itunes.data.ItuneDto
import com.example.itunes.data.VideoListAdapter
import com.example.itunes.data.VideoRecyclerViewItem
import com.example.itunes.databinding.FragmentVideoListBinding
import com.example.itunes.db.AppDatabase
import com.example.itunes.info.VideoInfoActivity
import com.example.itunes.network.IResult
import com.example.itunes.util.AppConstants
import com.example.itunes.util.VideoListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VideoListFragment : IBaseFragment<FragmentVideoListBinding, VideoListViewModel>(), OnAdapterItemClickListener {

    companion object {

        fun newInstance(): VideoListFragment {
            return VideoListFragment()
        }
    }

    private val videoListAdapter by lazy {
        VideoListAdapter()
    }

    private val appDatabase: AppDatabase by lazy {
        AppDatabase.getAppDatabase(requireContext())
    }

    private val viewModelFactory: VideosViewModelFactory by lazy {
        VideosViewModelFactory(GetVideosUseCase(IVideoListRepository(App.getInstance().getService())), appDatabase)
    }

    override val viewModel: VideoListViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(VideoListViewModel::class.java)
    }

    override fun getViewBinding(inflater: LayoutInflater): FragmentVideoListBinding {
        return FragmentVideoListBinding.inflate(inflater)
    }

    override fun setupView() {
        viewModel.getVideoList()
        binding.videoList.apply {
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            adapter = videoListAdapter
            addItemDecoration(object : RecyclerView.ItemDecoration() {
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    outRect.bottom = 12
                }
            })
        }
    }

    override fun setupObserver() {
        viewModel.videoList.observe(this, Observer {
            when(it) {
                is IResult.Loading -> {
                    binding.videoNetworkLoader.show()
                    binding.noInternetLayout.hide()
                }
                is IResult.Error -> {
                    binding.videoNetworkLoader.hide()
                    binding.noInternetLayout.show()
                }
                is IResult.Success -> {
                    binding.videoNetworkLoader.hide()
                    binding.noInternetLayout.hide()
                    if (it.data != null) {
                        it.data.results.forEach {ituneDto ->
                            videoListAdapter.addItem(VideoRecyclerViewItem(ituneDto, this))
                        }
                    }
                }
            }
        })
    }

    override fun onItemClicked(itemsDto: ItuneDto) {
        viewModel.saveToDatabase(itemsDto)
        val intent = Intent(requireActivity(), VideoInfoActivity::class.java).apply {
            putExtra(AppConstants.VIDEO_DETAIL_INTENT, itemsDto)
        }
        startActivity(intent)
    }
}