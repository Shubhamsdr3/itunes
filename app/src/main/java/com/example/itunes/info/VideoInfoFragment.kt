package com.example.itunes.info

import android.view.LayoutInflater
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.itunes.base.IBaseFragment
import com.example.itunes.data.ItuneDto
import com.example.itunes.databinding.FragmentVideoInfoBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VideoInfoFragment : IBaseFragment<FragmentVideoInfoBinding, VideoInfoViewModel>() {

    override val viewModel: VideoInfoViewModel by lazy {
        ViewModelProvider(this).get(VideoInfoViewModel::class.java)
    }

    companion object {

        private const val VIDEO_INFO = "video_info"

        fun newInstance(ituneDto: ItuneDto): VideoInfoFragment {
            return VideoInfoFragment().apply {
                arguments = bundleOf(
                    Pair(VIDEO_INFO, ituneDto)
                )
            }
        }
    }

    private val videoDetail: ItuneDto by lazy {
        requireArguments().getSerializable(VIDEO_INFO) as ItuneDto
    }

    override fun getViewBinding(inflater: LayoutInflater): FragmentVideoInfoBinding {
        return FragmentVideoInfoBinding.inflate(inflater)
    }

    override fun setupView() {
        binding.videoInfoTitle.text = videoDetail.trackName
        binding.videoInfoSubtitle.text = videoDetail.artistName
        binding.videoReleaseDate.text = videoDetail.releaseDate
        Glide.with(requireContext()).load(videoDetail.previewImage).into(binding.videoInfoImage)
    }

    override fun setupObserver() {
        viewModel.videoDetail.observe(this, Observer {

        })
    }
}