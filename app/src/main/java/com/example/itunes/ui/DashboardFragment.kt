package com.example.itunes.ui

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.itunes.base.IBaseFragment
import com.example.itunes.data.DashboardPagerAdapter
import com.example.itunes.databinding.FragmentDashboardBinding
import com.example.itunes.history.VideoHistoryFragment
import com.example.itunes.util.DashboardViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class DashboardFragment : IBaseFragment<FragmentDashboardBinding, DashboardViewModel>() {

    companion object {
        fun newInstance() : DashboardFragment {
            return DashboardFragment()
        }
    }

    private val fragmentList = listOf<Fragment>(
        VideoListFragment.newInstance(),
        VideoHistoryFragment.newInstance()
    )

    private val dashboardPagerAdapter: DashboardPagerAdapter by lazy {
        DashboardPagerAdapter(childFragmentManager, fragmentList)
    }

    override val viewModel: DashboardViewModel by lazy {
        ViewModelProvider(this).get(DashboardViewModel::class.java)
    }

    override fun getViewBinding(inflater: LayoutInflater): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater)
    }

    override fun setupObserver() {

    }

    override fun setupView() {
        binding.viewPager.adapter = dashboardPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}