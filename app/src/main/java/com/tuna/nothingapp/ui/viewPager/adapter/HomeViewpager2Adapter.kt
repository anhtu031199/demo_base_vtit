package com.tuna.nothingapp.ui.viewPager.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.tuna.nothingapp.ui.viewPager.ui.AQIFragment
import com.tuna.nothingapp.ui.viewPager.ui.DailyFragment
import com.tuna.nothingapp.ui.viewPager.ui.HourlyFragment
import com.tuna.nothingapp.ui.viewPager.ui.NowFragment

class HomeViewpager2Adapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                NowFragment()
            }
            1 -> {
                HourlyFragment()
            }
            2 -> {
                DailyFragment()
            }
            3 -> {
                AQIFragment()
            }
            else -> {
                Fragment()
            }
        }
    }

}