package com.tuna.nothingapp.data.repository

import com.tuna.nothingapp.data.remote.request.LocationSuggestRequestBody
import com.tuna.nothingapp.data.remote.response.LocationSuggestResponse

interface LocationRepository {
    suspend fun getSuggestLocation(locationSuggestRequestBody: LocationSuggestRequestBody): LocationSuggestResponse
}