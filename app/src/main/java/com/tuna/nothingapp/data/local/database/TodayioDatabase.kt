package com.tuna.nothingapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tuna.nothingapp.data.local.dao.LocationDAO
import com.tuna.nothingapp.data.local.dao.WeatherDAO
import com.tuna.nothingapp.data.local.entity.Location
import com.tuna.nothingapp.data.remote.response.WeatherResponse
import com.tuna.nothingapp.utils.Converter

@Database(entities = [WeatherResponse::class, Location::class], version = 1, exportSchema = false)
@TypeConverters(Converter::class)
abstract class TodayioDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDAO
    abstract fun locationDao(): LocationDAO
}