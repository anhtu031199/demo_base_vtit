package com.tuna.nothingapp.ui.viewPager.ui

import androidx.fragment.app.activityViewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentAqiBinding
import com.tuna.nothingapp.databinding.FragmentCityListBinding
import com.tuna.nothingapp.databinding.FragmentNowBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AQIFragment : BaseFragment<MainSharedViewModel, FragmentAqiBinding>() {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_aqi

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
    }

    override fun initData() {
    }

}