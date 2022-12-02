package com.tuna.nothingapp.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentSplashBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private lateinit var viewModel: MainSharedViewModel

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun initView() {}

    override fun initData() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[MainSharedViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.getWeather()
        }
        navigateToHome(view)
    }

    private fun navigateToHome(view: View) {
        val action = SplashFragmentDirections.actionSplashFragmentToHomeFragment()
        lifecycleScope.launch {
            delay(2500L)
            if (viewModel.demo.value.isNullOrEmpty()) navigateToHome(view)
            else view.findNavController().navigate(action)
        }
    }
}