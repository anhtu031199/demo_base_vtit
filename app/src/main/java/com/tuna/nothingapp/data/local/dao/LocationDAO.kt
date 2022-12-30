package com.tuna.nothingapp.data.local.dao

import androidx.room.*
import com.tuna.nothingapp.data.local.entity.Location

@Dao
interface LocationDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLocation(location: Location)

    @Query("SELECT * FROM location")
    fun getAllLocation(): List<Location>

    @Delete
    suspend fun deleteLocation(location: Location)

    @Update
    suspend fun updateLocation(location: Location)
}