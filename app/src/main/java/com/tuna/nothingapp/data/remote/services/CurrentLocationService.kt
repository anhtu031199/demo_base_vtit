package com.tuna.nothingapp.data.remote.services

import com.tuna.nothingapp.data.remote.response.CurrentLocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentLocationService {
    @GET("revgeocode")
    suspend fun getCurrentLocation(
        @Query("at") at: String,
        @Query("apiKey") apiKey: String
    ): CurrentLocationResponse
}