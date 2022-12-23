package com.tuna.nothingapp.ui.main

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.annotation.SuppressLint
import androidx.activity.viewModels
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.tuna.nothingapp.BR
import com.tuna.nothingapp.R
import com.tuna.nothingapp.base.BaseActivity
import com.tuna.nothingapp.databinding.ActivityMainBinding
import com.tuna.nothingapp.utils.hasPermission
import com.tuna.nothingapp.viewmodel.MainSharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.EasyPermissions
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : BaseActivity<MainSharedViewModel, ActivityMainBinding>(),
    EasyPermissions.PermissionCallbacks {
    override val viewModel: MainSharedViewModel by viewModels()

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModelBindingVariable(): Int = BR._all
    private lateinit var fusedLocationProvider: FusedLocationProviderClient
    override fun initView() {
        fusedLocationProvider = LocationServices.getFusedLocationProviderClient(this@MainActivity)
    }

    @SuppressLint("MissingPermission")
    override fun initData() {
        initPermission(ACCESS_FINE_LOCATION)
    }

    private fun initPermission(permission: String) {
        if (!hasPermission(permission)) {
            requestPermissions(arrayOf(permission), permission.length)
        } else {
            onRequestPermissionSuccess()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    @SuppressLint("MissingPermission")
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        when (requestCode) {
            ACCESS_FINE_LOCATION.length -> {
                Timber.d("tuna: ACCESS_FINE_LOCATION granted")
                onRequestPermissionSuccess()
            }
        }
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            when (requestCode) {
                ACCESS_FINE_LOCATION.length -> Timber.d("tuna: ACCESS_FINE_LOCATION denied")
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun onRequestPermissionSuccess() {
        fusedLocationProvider = LocationServices.getFusedLocationProviderClient(this@MainActivity)
        fusedLocationProvider.lastLocation.addOnCompleteListener {
            if (it.isSuccessful) {
                if (it.result != null) {
                    viewModel.updateLocation(it.result.latitude, it.result.longitude)
                    Timber.d("tuna: onSuccess")
                }
            } else {
                Timber.d("tuna: onFail")
            }
        }
        viewModel.hasLocationPermission()
        Timber.d("tuna: get Location success")
    }
}