package com.tuna.nothingapp.navigation

import android.net.Uri
import androidx.annotation.IdRes
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

/**
 * A simple sealed class to handle more properly
 * navigation from a [ViewModel]
 */
sealed class NavigationCommand {
    companion object {
        const val IS_REFRESH_HOME = "isRefreshHome"
    }

    data class To(
        val directions: NavDirections,
        val navExtras: androidx.navigation.Navigator.Extras? = null
    ) : NavigationCommand()

    data class ParentTo(val directions: NavDirections) : NavigationCommand()
    data class DeepLinkTo(val uri: Uri) : NavigationCommand()
    data class ParentDeepLinkTo(val uri: Uri) : NavigationCommand()
    data class BackTo(@IdRes val destinationId: Int, val inclusive: Boolean) : NavigationCommand()
    object Back : NavigationCommand()
    object ToRoot : NavigationCommand()
}
