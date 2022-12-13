package com.tuna.nothingapp.data.repository.impl

import com.tuna.nothingapp.data.remote.request.CurrentLocationRequestBody
import com.tuna.nothingapp.data.remote.request.SearchLocationRequestBody
import com.tuna.nothingapp.data.remote.response.CurrentLocationResponse
import com.tuna.nothingapp.data.remote.response.LocationSearchResponse
import com.tuna.nothingapp.data.remote.services.CurrentLocationService
import com.tuna.nothingapp.data.repository.CurrentLocationRepository
import javax.inject.Inject

class CurrentLocationRepositoryImpl @Inject constructor(private val currentLocationService: CurrentLocationService) :
    CurrentLocationRepository {
    override suspend fun getCurrentLocationName(currentLocationRequestBody: CurrentLocationRequestBody): CurrentLocationResponse {
        val response = currentLocationService.getCurrentLocation(currentLocationRequestBody.at, currentLocationRequestBody.apiKey)
        return response
    }
}