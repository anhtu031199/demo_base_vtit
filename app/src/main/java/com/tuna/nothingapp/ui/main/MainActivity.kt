package com.tuna.nothingapp.ui.main

import android.Manifest
import android.annotation.SuppressLint
import androidx.activity.viewModels
import com.google.android.gms.location.LocationServices
import com.tbruyelle.rxpermissions3.RxPermissions
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseActivity
import com.tuna.nothingapp.databinding.ActivityMainBinding
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<MainSharedViewModel, ActivityMainBinding>() {
    override val viewModel: MainSharedViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelBindingVariable(): Int = BR._all

    override fun initView() {}

    @SuppressLint("MissingPermission")
    override fun initData() {
        val fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        val rxPermission = RxPermissions(this)

        rxPermission
            .request(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            .subscribe(
                {
                    viewModel.hasLocationPermission()
                    val location = fusedLocationProviderClient.lastLocation
                    location.addOnSuccessListener {
                        if (it != null) {
                            viewModel.updateLocation(it.latitude, it.longitude)
                            Timber.d("tuna: onSuccess")
                        }
                    }

                },
                {
                    Timber.d("tuna: onFail")
                })
    }
}