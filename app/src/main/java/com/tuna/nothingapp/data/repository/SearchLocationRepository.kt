package com.tuna.nothingapp.data.repository

import com.tuna.nothingapp.data.remote.request.SearchLocationRequestBody
import com.tuna.nothingapp.data.remote.response.LocationSearchResponse

interface SearchLocationRepository {
    suspend fun getSearchLocation(searchLocationRequestBody: SearchLocationRequestBody): LocationSearchResponse
}