package com.tuna.nothingapp.data.repository.impl

import com.tuna.nothingapp.data.remote.request.WeatherRequestBody
import com.tuna.nothingapp.data.remote.response.WeatherResponse
import com.tuna.nothingapp.data.remote.services.WeatherService
import com.tuna.nothingapp.data.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(private val weatherService: WeatherService) :
    WeatherRepository {
    override suspend fun getCurrentWeather(weatherRequestBody: WeatherRequestBody): WeatherResponse {
        return weatherService.getCurrentWeather(
            weatherRequestBody.lat,
            weatherRequestBody.lon,
            weatherRequestBody.units,
            weatherRequestBody.appID
        )
    }
}