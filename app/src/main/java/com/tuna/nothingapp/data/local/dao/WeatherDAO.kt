package com.tuna.nothingapp.data.local.dao

import androidx.room.*
import com.tuna.nothingapp.data.remote.response.WeatherResponse

@Dao
interface WeatherDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLastestWeatherInfo(weatherResponse: WeatherResponse)

    @Query("SELECT * FROM weather")
    fun getLastestWeather(): WeatherResponse

    @Query("DELETE FROM weather")
    suspend fun deleteLocalWeatherInfo()
}