package com.tuna.nothingapp.navigation

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class NavigatorImpl @Inject constructor(
    @ActivityContext private val activityContext: Context
) : Navigator {

    private val activity get() = (activityContext as? AppCompatActivity)
    private val fragment get() = activity?.supportFragmentManager?.fragments?.firstOrNull()
    override val navController get() = fragment?.findNavController()
    override val parentNavController
        get() = (fragment?.parentFragment?.parentFragment)?.findNavController()
            ?: (fragment?.parentFragment)?.findNavController()

    override suspend fun openDeeplink(deeplink: String) {
    }

    override fun showNetworkDialog(onRefresh: () -> Unit) {
    }

    override fun showServerErrorDialog(onRefresh: () -> Unit) {
    }
}
