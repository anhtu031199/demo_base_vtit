package com.tuna.nothingapp.ui.home

import androidx.fragment.app.activityViewModels
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentHomeBinding
import com.tuna.nothingapp.ui.viewPager.adapter.HomeViewpager2Adapter
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<MainSharedViewModel, FragmentHomeBinding>() {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        viewModel.showLoading.observe(viewLifecycleOwner) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }
        setupViewPager()
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.ic_weather_day_cloud)
            .override(10, 10)
            .fitCenter()
            .into(binding.imgWeatherCurrentBlur)
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.ic_weather_day_cloud)
            .placeholder(R.drawable.img_home_background)
            .fitCenter()
            .into(binding.imgWeatherCurrent)
    }

    override fun initData() {
        viewModel.longitude.observe(viewLifecycleOwner) {
            viewModel.initData()
            Timber.d("tuna: longitude observer")
        }
        viewModel.currentLocation.observe(viewLifecycleOwner) {
            showToast(it)
            Timber.d("tuna: $it")
            Timber.d("tuna: current location observer")
        }
    }

    private fun setupViewPager() {
        val adapter = HomeViewpager2Adapter(parentFragmentManager, lifecycle)
        binding.viewPagerHome.adapter = adapter
        binding.bottomNavbarHome.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_now -> {
                    binding.viewPagerHome.currentItem = 0
                    true
                }
                R.id.menu_hourly -> {
                    binding.viewPagerHome.currentItem = 1
                    true
                }
                R.id.menu_daily -> {
                    binding.viewPagerHome.currentItem = 2
                    true
                }
                R.id.menu_aqi -> {
                    binding.viewPagerHome.currentItem = 3
                    true
                }
                else -> {
                    binding.viewPagerHome.currentItem = 0
                    true
                }
            }
        }
        binding.viewPagerHome.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.bottomNavbarHome.menu.findItem(R.id.menu_now).isChecked = true
                    }
                    1 -> {
                        binding.bottomNavbarHome.menu.findItem(R.id.menu_hourly).isChecked = true
                    }
                    2 -> {
                        binding.bottomNavbarHome.menu.findItem(R.id.menu_daily).isChecked = true
                    }
                    3 -> {
                        binding.bottomNavbarHome.menu.findItem(R.id.menu_aqi).isChecked = true
                    }
                    else -> {

                    }
                }
                super.onPageSelected(position)
            }
        })
    }
}