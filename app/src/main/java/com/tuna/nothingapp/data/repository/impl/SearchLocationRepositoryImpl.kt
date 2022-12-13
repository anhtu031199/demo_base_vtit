package com.tuna.nothingapp.data.repository.impl

import com.tuna.nothingapp.data.remote.request.SearchLocationRequestBody
import com.tuna.nothingapp.data.remote.response.LocationSearchResponse
import com.tuna.nothingapp.data.remote.services.SearchLocationService
import com.tuna.nothingapp.data.repository.SearchLocationRepository
import javax.inject.Inject

class SearchLocationRepositoryImpl @Inject constructor(private val searchLocationService: SearchLocationService) :
    SearchLocationRepository {
    override suspend fun getSearchLocation(searchLocationRequestBody: SearchLocationRequestBody): LocationSearchResponse {
        val response = searchLocationService.getSearchLocation(
            searchLocationRequestBody.q,
            searchLocationRequestBody.apiKey
        )
        return response
    }
}