package com.tuna.nothingapp.navigation

import androidx.navigation.NavController

interface Navigator {
    val navController: NavController?
    val parentNavController: NavController?

    suspend fun openDeeplink(deeplink: String)
    fun showNetworkDialog(onRefresh: () -> Unit)
    fun showServerErrorDialog(onRefresh: () -> Unit)
}
