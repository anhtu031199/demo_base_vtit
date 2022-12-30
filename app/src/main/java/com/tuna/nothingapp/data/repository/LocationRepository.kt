package com.tuna.nothingapp.data.repository

import com.tuna.nothingapp.data.local.entity.Location

interface LocationRepository {
    fun getAllLocation(): List<Location>

    suspend fun insertLocation(location: Location)

    suspend fun deleteLocation(location: Location)

    suspend fun updateLocation(location: Location)
}