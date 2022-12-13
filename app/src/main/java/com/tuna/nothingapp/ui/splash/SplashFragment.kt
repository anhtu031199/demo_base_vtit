package com.tuna.nothingapp.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentSplashBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SplashFragment : BaseFragment<MainSharedViewModel, FragmentSplashBinding>() {

    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_splash

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {}

    override fun initData() {
        viewModel.hasLocationPermission.observe(viewLifecycleOwner){
//            viewModel.initData()
            viewModel.navigateSplashToHome()
            Timber.d("tuna: hasLocationPermission observer")
        }
//        viewModel.hasData.observe(viewLifecycleOwner){
//            if (it){
//                viewModel.navigateSplashToHome()
//            }
//            Timber.d("tuna: hasData observer")
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}