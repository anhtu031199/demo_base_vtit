package com.tuna.nothingapp.data.remote.services

import com.tuna.nothingapp.data.remote.response.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("onecall")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String,
        @Query("appid") appid: String
    ): WeatherResponse
}