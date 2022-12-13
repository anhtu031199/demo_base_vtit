package com.tuna.nothingapp.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.tuna.nothingapp.navigation.NavigationCommand
import com.tuna.nothingapp.navigation.Navigator
import com.tuna.nothingapp.utils.SingleLiveEvent

open class BaseViewModel(val app: Application) : AndroidViewModel(app) {
    val navigateEvent by lazy { SingleLiveEvent<NavigationCommand>() }

    private lateinit var _navigator: Navigator
    val navigator get() = _navigator

    fun setNavigator(navigator: Navigator){
        _navigator= navigator
    }

    fun navigateBack() {
        navigate(NavigationCommand.Back)
    }

    fun navigate(navigationCommand: NavigationCommand) {
        navigateEvent.value = navigationCommand
    }
}