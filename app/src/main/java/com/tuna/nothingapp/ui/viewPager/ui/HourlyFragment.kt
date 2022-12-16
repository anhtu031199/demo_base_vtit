package com.tuna.nothingapp.ui.viewPager.ui

import androidx.fragment.app.activityViewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentHourlyBinding
import com.tuna.nothingapp.ui.viewPager.data.HourlyItemUI
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HourlyFragment : BaseFragment<MainSharedViewModel, FragmentHourlyBinding>(),
    MainSharedViewModel.HourlyCallback {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_hourly

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        viewModel.hourlyCallback = this
    }

    override fun initData() {
    }

    override fun onHourlyItemClick(item: HourlyItemUI) {
        showToast("Details dialog coming soon")
    }
}