package com.tuna.nothingapp.ui.location

import androidx.fragment.app.activityViewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentLocationBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationFragment : BaseFragment<MainSharedViewModel, FragmentLocationBinding>() {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_location

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
    }

    override fun initData() {
    }

}