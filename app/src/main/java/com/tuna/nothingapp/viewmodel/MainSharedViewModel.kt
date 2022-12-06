package com.tuna.nothingapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tuna.nothingapp.base.BaseViewModel
import com.tuna.nothingapp.data.remote.request.WeatherRequestBody
import com.tuna.nothingapp.data.remote.response.Current
import com.tuna.nothingapp.data.repository.WeatherRepository
import com.tuna.nothingapp.navigation.NavigationCommand
import com.tuna.nothingapp.ui.home.HomeFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.net.ConnectException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainSharedViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    @ApplicationContext context: Context
) : BaseViewModel() {
    private var _demo = MutableLiveData<String>()
    val demo: LiveData<String> = _demo

    var current = MutableLiveData<Current>()
    var currentTemp = MutableLiveData<Int>()
    var feelsLikeTemp = MutableLiveData<Int>()
    var dateTime = MutableLiveData<String>()
    fun getWeather() {
        viewModelScope.launch {
            try {
                val weather = weatherRepository.getCurrentWeather(WeatherRequestBody(0.0, 0.0))
                _demo.value = weather.toString()
                current.value = weather.current
                currentTemp.value = weather.current.temp.toInt()
                feelsLikeTemp.value = weather.current.feels_like.toInt()
                Timber.d("Weather: ${weather.current}")
            } catch (e: Exception) {
                Timber.e("tuna: $e")
                if (e is ConnectException) {
                    delay(2000L)
                    getWeather()
                }
            }
        }
        dateTime.value = SimpleDateFormat("EEE, d MMM", Locale.ENGLISH).format(Date())
    }

    fun navigateHomeToCityList() {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToCityListFragment()
            )
        )
    }
    fun navigateHomeToForecast() {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToForecastFragment()
            )
        )
    }
    fun navigateHomeToAQI() {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToAqiFragent()
            )
        )
    }
    fun navigateHomeToSetting() {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToSettingFragment()
            )
        )
    }
}