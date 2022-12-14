package com.tuna.nothingapp.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tuna.nothingapp.base.BaseViewModel
import com.tuna.nothingapp.data.remote.request.CurrentLocationRequestBody
import com.tuna.nothingapp.data.remote.request.WeatherRequestBody
import com.tuna.nothingapp.data.remote.response.Current
import com.tuna.nothingapp.data.remote.response.CurrentLocationResponse
import com.tuna.nothingapp.data.repository.CurrentLocationRepository
import com.tuna.nothingapp.data.repository.SearchLocationRepository
import com.tuna.nothingapp.data.repository.WeatherRepository
import com.tuna.nothingapp.navigation.NavigationCommand
import com.tuna.nothingapp.ui.home.HomeFragmentDirections
import com.tuna.nothingapp.ui.splash.SplashFragmentDirections
import com.tuna.nothingapp.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber
import java.net.ConnectException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class MainSharedViewModel @Inject constructor(
    app: Application,
    private val weatherRepository: WeatherRepository,
    private val searchLocationRepository: SearchLocationRepository,
    private val currentLocationRepository: CurrentLocationRepository
) : BaseViewModel(app) {
    private var _currentWeather = SingleLiveEvent<Current>()
    private var _currentLocation = SingleLiveEvent<String>()
    private var _currentTemp = SingleLiveEvent<Int>()
    private var _feelsLikeTemp = SingleLiveEvent<Int>()
    private var _dateTime = SingleLiveEvent<String>()
    private var _longitude = SingleLiveEvent<Double>()
    private var _latitude = SingleLiveEvent<Double>()
    private val _hasLocationPermission = SingleLiveEvent<Boolean>()
    private val _errorMessage = SingleLiveEvent<String>()

    val currentWeather: SingleLiveEvent<Current> = _currentWeather
    val currentLocation: SingleLiveEvent<String> = _currentLocation
    val currentTemp: SingleLiveEvent<Int> = _currentTemp
    val feelsLikeTemp: SingleLiveEvent<Int> = _feelsLikeTemp
    val dateTime: SingleLiveEvent<String> = _dateTime
    val hasLocationPermission: SingleLiveEvent<Boolean> = _hasLocationPermission
    val longitude: SingleLiveEvent<Double> = _longitude
    val latitude: SingleLiveEvent<Double> = _latitude
    val showLoading = SingleLiveEvent<Boolean>()
    val showErrorDialog = SingleLiveEvent<Boolean>()
    val hasData = SingleLiveEvent<Boolean>()
    val errorMessage: SingleLiveEvent<String> = _errorMessage

    fun initData() {
        viewModelScope.launch {
            showErrorDialog.value = false
            showLoading.value = true
            try {
                val weather = weatherRepository.getCurrentWeather(WeatherRequestBody(latitude.value?:0.0, longitude.value?:0.0))
                _currentWeather.value = weather.current
                _currentTemp.value = weather.current.temp.toInt()
                _feelsLikeTemp.value = weather.current.feels_like.toInt()
                Timber.d("Weather: $weather")
                hasData.value = true
                val location = currentLocationRepository.getCurrentLocationName(
                    CurrentLocationRequestBody("${_latitude.value},${_longitude.value}")
                )
                _currentLocation.value = location.items[0].address.district
                showLoading.value = false
            } catch (e: Exception) {
                hasData.value = false
                _errorMessage.value = e.message
                showErrorDialog.value = true
                Timber.e("tuna: $e")
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

    fun navigateSplashToHome() {
        viewModelScope.launch {
            delay(2000L)
            navigate(
                NavigationCommand.To(
                    SplashFragmentDirections.actionSplashFragmentToHomeFragment()
                )
            )
        }
    }

    fun hasLocationPermission(){
        _hasLocationPermission.value = true
    }

    fun updateLocation(lat: Double, lon: Double){
        _latitude.value = lat
        _longitude.value = lon
//        initData()
    }
}