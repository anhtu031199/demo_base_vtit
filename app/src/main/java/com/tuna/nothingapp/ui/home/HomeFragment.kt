package com.tuna.nothingapp.ui.home

import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.databinding.FragmentHomeBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<MainSharedViewModel, FragmentHomeBinding>() {
    override val viewModel: MainSharedViewModel by activityViewModels()

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModelBindingVariable(): Int = BR.viewModel

    override fun initView() {
        Glide.with(this)
            .asBitmap()
            .load(R.drawable.img_background_home)
            .override(250, 250)
            .placeholder(R.drawable.img_home_background)
            .fitCenter()
            .into(binding.imgBackground)
    }

    override fun initData() {
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                activity?.finish()
            }

        })
    }

}