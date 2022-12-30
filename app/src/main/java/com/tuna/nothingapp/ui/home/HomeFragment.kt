package com.tuna.nothingapp.ui.home

import android.os.Handler
import android.os.Looper
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseFragment
import com.tuna.nothingapp.data.local.model.HourlyItemUI
import com.tuna.nothingapp.databinding.FragmentHomeBinding
import com.tuna.nothingapp.extensions.orDefault
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : BaseFragment<MainSharedViewModel, FragmentHomeBinding>(), MainSharedViewModel.HourlyCallback {
    override val viewModel: MainSharedViewModel by activityViewModels()
    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModelBindingVariable(): Int = BR.viewModel
    var doubleBackToExitPressedOnce = false
    override fun initView() {
        onBackPress()
        viewModel.showLoading.observeSingle(viewLifecycleOwner) {
            if (it) {
                showLoading()
            } else {
                hideLoading()
            }
        }
        viewModel.showErrorDialog.observeSingle(viewLifecycleOwner) {
            if (it) {
                showErrorDialog(
                    message = viewModel.errorMessage.value.orDefault(),
                    positiveButton = "Retry",
                    onPositive = {
                        viewModel.initData()
                    })
            } else {
                hideDialog()
            }
        }
        viewModel.hourlyCallback = this
    }

    private fun onBackPress() {
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (doubleBackToExitPressedOnce) {
                        requireActivity().finish()
                        return
                    }

                    doubleBackToExitPressedOnce = true
                    showToast(getString(R.string.confirm_exit))

                    Handler(Looper.getMainLooper()).postDelayed({
                        doubleBackToExitPressedOnce = false
                    }, 2000)
                }
            })
    }

    override fun initData() {
        viewModel.longitude.observeSingle(viewLifecycleOwner) {
            Timber.d("tuna: longitude observer")
            viewModel.initData()
        }
        viewModel.currentLocation.observeSingle(viewLifecycleOwner) {
//            showToast(it)
//            Timber.d("tuna: $it")
            Timber.d("tuna: current location observer")
        }
        binding.swipeRefresh.setOnRefreshListener {
            binding.swipeRefresh.isRefreshing = false
            lifecycleScope.launch {
                viewModel.initData()
            }
        }
        viewModel.demoLocationList()
    }

    override fun onHourlyItemClick(item: HourlyItemUI) {
        showToast("Details dialog coming soon")
    }
}