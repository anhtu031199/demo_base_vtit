package com.tuna.nothingapp.data.repository.impl

import com.tuna.nothingapp.data.local.dao.LocationDAO
import com.tuna.nothingapp.data.local.entity.Location
import com.tuna.nothingapp.data.repository.LocationRepository
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    private val locationDAO: LocationDAO
    ): LocationRepository {
    override fun getAllLocation(): List<Location> {
        return locationDAO.getAllLocation()
    }

    override suspend fun insertLocation(location: Location) {
        locationDAO.insertLocation(location)
    }

    override suspend fun deleteLocation(location: Location) {
        locationDAO.deleteLocation(location)
    }

    override suspend fun updateLocation(location: Location) {
        locationDAO.updateLocation(location)
    }
}