package com.tuna.nothingapp.ui.main

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import androidx.activity.viewModels
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority.PRIORITY_HIGH_ACCURACY
import com.tbruyelle.rxpermissions3.RxPermissions
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseActivity
import com.tuna.nothingapp.databinding.ActivityMainBinding
import com.tuna.nothingapp.utils.hasLocationPermission
import com.tuna.nothingapp.utils.hasPermission
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<MainSharedViewModel, ActivityMainBinding>() {
    override val viewModel: MainSharedViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelBindingVariable(): Int = BR._all

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun initView() {
    }

    @SuppressLint("MissingPermission")
    override fun initData() {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        checkPermission()
    }

    private fun checkPermission() {
        if (!hasLocationPermission()) {
            initPermission()
        } else {
            onRequestPermissionSuccess()
        }
    }

    private fun initPermission() {
        val rxPermission = RxPermissions(this)
        rxPermission
            .request(
                ACCESS_FINE_LOCATION,
                ACCESS_COARSE_LOCATION
            )
            .subscribe(
                {
                    onRequestPermissionSuccess()
                },
                {
                    Timber.d("tuna: onFail")
                })
    }

    private fun onRequestPermissionSuccess() {
        viewModel.hasLocationPermission()
        val location = fusedLocationProviderClient.getCurrentLocation(PRIORITY_HIGH_ACCURACY, null)
//        val location = fusedLocationProviderClient.lastLocation
        location.addOnSuccessListener {
            if (it != null) {
                viewModel.updateLocation(it.latitude, it.longitude)
                Timber.d("tuna: onSuccess")
            }
        }
        Timber.d("tuna: get Location success")
    }
}