package com.tuna.nothingapp.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentSplashBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<MainSharedViewModel, FragmentSplashBinding>() {

    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {}

    override fun initData() {
        viewModel.initData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigateToHome(view)
    }

    private fun navigateToHome(view: View) {
        val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        lifecycleScope.launch {
            delay(1500L)
            if (viewModel.demo.value.isNullOrEmpty()) navigateToHome(view)
            else view.findNavController().navigate(action)
        }
    }
}