package com.example.itunes.data

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

const val HISTORY = "History"
const val VIDEOS = "Videos"

class DashboardPagerAdapter(
    fragmentManager: FragmentManager,
    private val fragmentList: List<Fragment>
): FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0) {
            return VIDEOS
        }
        return HISTORY
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.count()
    }
}