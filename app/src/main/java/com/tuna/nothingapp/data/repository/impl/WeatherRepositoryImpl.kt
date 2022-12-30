package com.tuna.nothingapp.data.repository.impl

import com.tuna.nothingapp.data.local.dao.WeatherDAO
import com.tuna.nothingapp.data.remote.request.WeatherRequestBody
import com.tuna.nothingapp.data.remote.response.WeatherResponse
import com.tuna.nothingapp.data.remote.services.WeatherService
import com.tuna.nothingapp.data.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherService: WeatherService,
    private val weatherDAO: WeatherDAO
) : WeatherRepository {

    override suspend fun getCurrentWeather(weatherRequestBody: WeatherRequestBody): WeatherResponse {
        return weatherService.getCurrentWeather(
            weatherRequestBody.lat,
            weatherRequestBody.lon,
            weatherRequestBody.units,
            weatherRequestBody.appID
        )
    }

    override suspend fun getLocalWeather(): WeatherResponse? {
        return weatherDAO.getLastestWeather()
    }

    override suspend fun insertWeatherToDB(weather: WeatherResponse) {
        weatherDAO.insertLastestWeatherInfo(weather)
    }

    override suspend fun deleteLocalWeather() {
        weatherDAO.deleteLocalWeatherInfo()
    }
}