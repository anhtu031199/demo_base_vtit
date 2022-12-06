package com.tuna.nothingapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentHomeBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<MainSharedViewModel, FragmentHomeBinding>() {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.ic_weather_night_cloud)
            .override(10, 10)
            .fitCenter()
            .into(binding.imgWeatherCurrentBlur)
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.ic_weather_night_cloud)
            .placeholder(R.drawable.img_home_background)
            .fitCenter()
            .into(binding.imgWeatherCurrent)
    }

    override fun initData() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNavbarBottom1.setOnClickListener {
            viewModel.navigateHomeToForecast()
        }
        binding.btnNavbarBottom2.setOnClickListener {
            viewModel.navigateHomeToCityList()
        }
        binding.btnNavbarBottom3.setOnClickListener {
            viewModel.navigateHomeToAQI()
        }
        binding.btnNavbarBottom4.setOnClickListener {
            viewModel.navigateHomeToSetting()
        }
    }

}