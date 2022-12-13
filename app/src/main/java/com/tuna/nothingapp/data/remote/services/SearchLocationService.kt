package com.tuna.nothingapp.data.remote.services

import com.tuna.nothingapp.data.remote.response.LocationSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchLocationService {
    @GET("geocode")
    suspend fun getSearchLocation(
        @Query("q") q: String,
        @Query("apiKey") apiKey: String
    ): LocationSearchResponse
}