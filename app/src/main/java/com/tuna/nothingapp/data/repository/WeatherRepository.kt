package com.tuna.nothingapp.data.repository

import com.tuna.nothingapp.data.remote.request.WeatherRequestBody
import com.tuna.nothingapp.data.remote.response.WeatherResponse

interface WeatherRepository {
    suspend fun getCurrentWeather(weatherRequestBody: WeatherRequestBody): WeatherResponse

    suspend fun getLocalWeather(): WeatherResponse?

    suspend fun insertWeatherToDB(weather: WeatherResponse)

    suspend fun deleteLocalWeather()
}