package com.tuna.nothingapp.data.repository.impl

import com.tuna.nothingapp.data.remote.request.LocationSuggestRequestBody
import com.tuna.nothingapp.data.remote.response.LocationSuggestResponse
import com.tuna.nothingapp.data.remote.services.LocationService
import com.tuna.nothingapp.data.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(private val locationService: LocationService) :
    LocationRepository {
    override suspend fun getSuggestLocation(locationSuggestRequestBody: LocationSuggestRequestBody): LocationSuggestResponse {
        val response = locationService.getSuggestLocation(
            locationSuggestRequestBody.q,
            locationSuggestRequestBody.apiKey
        )
        return response
    }
}