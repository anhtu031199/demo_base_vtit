package com.tuna.nothingapp.ui.viewPager.ui

import androidx.fragment.app.activityViewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentDailyBinding
import com.tuna.nothingapp.ui.viewPager.data.DailyItemUI
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DailyFragment : BaseFragment<MainSharedViewModel, FragmentDailyBinding>(),
    MainSharedViewModel.DailyCallback {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_daily

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        viewModel.dailyCallback = this
    }

    override fun initData() {
    }

    override fun onDailylyItemClick(item: DailyItemUI) {
        showToast("Details dialog coming soon")
    }

}