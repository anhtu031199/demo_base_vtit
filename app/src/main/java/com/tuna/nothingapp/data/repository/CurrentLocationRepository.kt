package com.tuna.nothingapp.data.repository

import com.tuna.nothingapp.data.remote.request.CurrentLocationRequestBody
import com.tuna.nothingapp.data.remote.response.CurrentLocationResponse

interface CurrentLocationRepository {
    suspend fun getCurrentLocationName(currentLocationRequestBody: CurrentLocationRequestBody) : CurrentLocationResponse
}