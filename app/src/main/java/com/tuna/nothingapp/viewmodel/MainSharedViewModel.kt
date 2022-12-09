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
    private var _current = MutableLiveData<Current>()
    private var _currentTemp = MutableLiveData<Int>()
    private var _feelsLikeTemp = MutableLiveData<Int>()
    private var _dateTime = MutableLiveData<String>()

    val demo: LiveData<String> = _demo
    val current: LiveData<Current> = _current
    val currentTemp: LiveData<Int> = _currentTemp
    val feelsLikeTemp: LiveData<Int> = _feelsLikeTemp
    val dateTime: LiveData<String> = _dateTime

    fun initData() {
        viewModelScope.launch {
            try {
                val weather = weatherRepository.getCurrentWeather(WeatherRequestBody(0.0, 0.0))
                _demo.value = weather.toString()
                _current.value = weather.current
                _currentTemp.value = weather.current.temp.toInt()
                _feelsLikeTemp.value = weather.current.feels_like.toInt()
                Timber.d("Weather: ${weather.current}")
            } catch (e: Exception) {
                Timber.e("tuna: $e")
                if (e is ConnectException) {
                    delay(2000L)
                    initData()
                }
            }
        }
        _dateTime.value = SimpleDateFormat("EEE, d MMM, ", Locale.ENGLISH).format(Date())
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

    fun navigateHomeToSetting() {
        navigate(
            NavigationCommand.To(
                HomeFragmentDirections.actionHomeFragmentToSettingFragment()
            )
        )
    }
}