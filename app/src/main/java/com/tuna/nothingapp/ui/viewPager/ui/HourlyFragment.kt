package com.tuna.nothingapp.ui.viewPager.ui

import androidx.fragment.app.activityViewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentHourlyBinding
import com.tuna.nothingapp.ui.viewPager.adapter.HourlyRecyclerAdapter
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HourlyFragment : BaseFragment<MainSharedViewModel, FragmentHourlyBinding>() {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_hourly

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
    }

    override fun initData() {
        binding.rcvHourly.adapter = viewModel.listHourlyForecast.value?.let {
            HourlyRecyclerAdapter(
                it
            )
        }
    }

}