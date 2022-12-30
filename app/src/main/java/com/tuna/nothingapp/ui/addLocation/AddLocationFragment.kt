package com.tuna.nothingapp.ui.addLocation

import androidx.fragment.app.activityViewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentAddLocationBinding
import com.tuna.nothingapp.databinding.FragmentSettingBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddLocationFragment : BaseFragment<MainSharedViewModel, FragmentAddLocationBinding>() {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_add_location

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
    }

    override fun initData() {

    }

}