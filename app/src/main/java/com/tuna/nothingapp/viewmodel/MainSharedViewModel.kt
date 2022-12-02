package com.tuna.nothingapp.viewmodel

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tuna.nothingapp.data.remote.request.WeatherRequestBody
import com.tuna.nothingapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import timber.log.Timber
import java.net.ConnectException
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class MainSharedViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
    @ApplicationContext context: Context
) : ViewModel() {
    var demo = MutableLiveData<String>()
    suspend fun getWeather(){
        try {
            val weather = weatherRepository.getCurrentWeather(WeatherRequestBody(0.0, 0.0))
            demo.value = weather.toString()
            Timber.d("Weather: ${weather.current}")
        }
        catch (e:Exception){
            Timber.e("tuna: $e")
            if (e is ConnectException){
                delay(5000L)
                getWeather()
            }
        }
    }
}