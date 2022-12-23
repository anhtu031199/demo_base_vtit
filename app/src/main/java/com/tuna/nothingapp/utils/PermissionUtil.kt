package com.tuna.nothingapp.utils

import android.Manifest.permission.*
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.net.Uri
import android.os.Build.VERSION.SDK_INT
import android.os.Build.VERSION_CODES.Q
import android.provider.Settings
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Activity.hasPermission(permission: String) = ContextCompat.checkSelfPermission(this, permission) == PERMISSION_GRANTED

fun Fragment.hasPermission(permission: String) = requireActivity().hasPermission(permission)

fun Activity.hasLocationPermission() = if (SDK_INT >= Q) {
    hasPermission(ACCESS_FINE_LOCATION) || hasPermission(ACCESS_BACKGROUND_LOCATION)
} else {
    hasPermission(ACCESS_FINE_LOCATION) && hasPermission(ACCESS_COARSE_LOCATION)
}

fun Fragment.hasLocationPermission() = requireActivity().hasLocationPermission()

fun Activity.openApplicationSettings() {
    val uri = Uri.fromParts("package", packageName, null)
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, uri)

    startActivity(intent)
}
