package com.example.itunes.info

import android.media.MediaPlayer
import android.os.Build
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.itunes.base.IBaseFragment
import com.example.itunes.data.ItuneDto
import com.example.itunes.databinding.FragmentVideoInfoBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class VideoInfoFragment : IBaseFragment<FragmentVideoInfoBinding, VideoInfoViewModel>() {

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

    private var mediaPlayer: MediaPlayer? = null

    override val viewModel: VideoInfoViewModel by lazy {
        ViewModelProvider(this).get(VideoInfoViewModel::class.java)
    }

    private val videoDetail: ItuneDto by lazy {
        requireArguments().getSerializable(VIDEO_INFO) as ItuneDto
    }

    override fun getViewBinding(inflater: LayoutInflater): FragmentVideoInfoBinding {
        return FragmentVideoInfoBinding.inflate(inflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun setupView() {
        binding.videoInfoTitle.text = videoDetail.trackName
        binding.videoInfoSubtitle.text = videoDetail.artistName
        binding.videoReleaseDate.text = videoDetail.releaseDate
        Glide.with(requireContext()).load(videoDetail.previewImage).into(binding.videoInfoImage)
    }

    override fun setupObserver() {
        mediaPlayer = MediaPlayer().apply {
            setDataSource(videoDetail.previewUrl)
            prepareAsync()
            setOnPreparedListener {
                start()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.apply {
            stop()
            release()
        }
        mediaPlayer = null
    }
}