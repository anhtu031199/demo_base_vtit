package com.tuna.nothingapp.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.tuna.nothingapp.utils.Converter

@Entity(tableName = "weather")
data class WeatherResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @TypeConverters(Converter::class)
    @SerializedName("current")
    val current: Current? = null,

    @TypeConverters(Converter::class)
    @SerializedName("daily")
    val daily: List<Daily>? = null,

    @TypeConverters(Converter::class)
    @SerializedName("hourly")
    val hourly: List<Hourly>? = null,

    @SerializedName("lat") val lat: Double,
    @SerializedName("lon") val lon: Double,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("timezone_offset") val timezone_offset: Int
)

data class Current(
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("dew_point") val dew_point: Double,
    @SerializedName("dt") val dt: Int,
    @SerializedName("feels_like") val feels_like: Double,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("rain") val rain: Rain,
    @SerializedName("sunrise") val sunrise: Int,
    @SerializedName("sunset") val sunset: Int,
    @SerializedName("temp") val temp: Double,
    @SerializedName("uvi") val uvi: Double,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("weather") val weather: List<Weather>? = null,
    @SerializedName("wind_deg") val wind_deg: Int,
    @SerializedName("wind_gust") val wind_gust: Double,
    @SerializedName("wind_speed") val wind_speed: Double
)

data class Daily(
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("dew_point") val dew_point: Double,
    @SerializedName("dt") val dt: Long,
    @SerializedName("feels_like") val feels_like: FeelsLike? = null,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("moon_phase") val moon_phase: Double,
    @SerializedName("moonrise") val moonrise: Int,
    @SerializedName("moonset") val moonset: Int,
    @SerializedName("pop") val pop: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("rain") val rain: Double,
    @SerializedName("sunrise") val sunrise: Int,
    @SerializedName("sunset") val sunset: Int,
    @SerializedName("temp") val temp: Temp,
    @SerializedName("uvi") val uvi: Double,
    @SerializedName("weather") val weather: List<Weather>? = null,
    @SerializedName("wind_deg") val wind_deg: Int,
    @SerializedName("wind_gust") val wind_gust: Double,
    @SerializedName("wind_speed") val wind_speed: Double
)

data class FeelsLike(
    @SerializedName("day") val day: Double,
    @SerializedName("eve") val eve: Double,
    @SerializedName("morn") val morn: Double,
    @SerializedName("night") val night: Double
)

data class Hourly(
    @SerializedName("clouds") val clouds: Int,
    @SerializedName("dew_point") val dew_point: Double,
    @SerializedName("dt") val dt: Long,
    @SerializedName("feels_like") val feels_like: Double,
    @SerializedName("humidity") val humidity: Int,
    @SerializedName("pop") val pop: Double,
    @SerializedName("pressure") val pressure: Int,
    @SerializedName("rain") val rain: Rain,
    @SerializedName("temp") val temp: Double,
    @SerializedName("uvi") val uvi: Double,
    @SerializedName("visibility") val visibility: Int,
    @SerializedName("weather") val weather: List<Weather>,
    @SerializedName("wind_deg") val wind_deg: Int,
    @SerializedName("wind_gust") val wind_gust: Double,
    @SerializedName("wind_speed") val wind_speed: Double
)

data class Rain(
    @SerializedName("1h") val `1h`: Double
)

data class Temp(
    @SerializedName("day") val day: Double,
    @SerializedName("eve") val eve: Double,
    @SerializedName("max") val max: Double,
    @SerializedName("min") val min: Double,
    @SerializedName("morn") val morn: Double,
    @SerializedName("night") val night: Double
)

data class Weather(
    @SerializedName("description") val description: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("id") val id: Int,
    @SerializedName("main") val main: String
)