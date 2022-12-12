package com.tuna.nothingapp.data.remote.services

import com.tuna.nothingapp.data.remote.response.LocationSuggestResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LocationService {
    @GET("geocode")
    suspend fun getSuggestLocation(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String
    ): LocationSuggestResponse
}