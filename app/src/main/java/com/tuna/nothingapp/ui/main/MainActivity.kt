package com.tuna.nothingapp.ui.main

import androidx.activity.viewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseActivity
import com.tuna.nothingapp.databinding.ActivityMainBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainSharedViewModel, ActivityMainBinding>() {
    override val viewModel: MainSharedViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelBindingVariable(): Int = BR._all

    override fun initView() {
    }

    override fun initData() {
    }

}