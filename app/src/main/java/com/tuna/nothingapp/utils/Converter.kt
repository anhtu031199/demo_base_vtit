package com.tuna.nothingapp.utils

import androidx.room.TypeConverter
import com.tuna.nothingapp.data.remote.response.*

class Converter {
    @TypeConverter
    fun toJson(data: Current?): String? {
        return data?.let { GsonManager.toJson(it) }
    }

    @TypeConverter
    fun toCurrent(data: String?): Current? {
        return data?.let { GsonManager.fromJson(it, Current::class.java) }
    }

    @TypeConverter
    fun dailytoJson(data: List<Daily>?): String? {
        return data?.let { GsonManager.toJson(it) }
    }

    @TypeConverter
    fun toListDaily(data: String?): List<Daily>? {
        return data?.let { GsonManager.fromJson(it, getTypeToken<List<Daily>>()) }
    }

    @TypeConverter
    fun toJson(data: FeelsLike?): String? {
        return data?.let { GsonManager.toJson(it) }
    }

    @TypeConverter
    fun toFeelsLike(data: String?): FeelsLike? {
        return data?.let { GsonManager.fromJson(it, FeelsLike::class.java) }
    }

    @TypeConverter
    fun hourlytoJson(data: List<Hourly>?): String? {
        return data?.let { GsonManager.toJson(it) }
    }

    @TypeConverter
    fun toListHourly(data: String?): List<Hourly>? {
        return data?.let { GsonManager.fromJson(it, getTypeToken<List<Hourly>>()) }
    }

    @TypeConverter
    fun toJson(data: Rain?): String? {
        return data?.let { GsonManager.toJson(it) }
    }

    @TypeConverter
    fun toRain(data: String?): Rain? {
        return data?.let { GsonManager.fromJson(it, Rain::class.java) }
    }

    @TypeConverter
    fun toJson(data: Temp?): String? {
        return data?.let { GsonManager.toJson(it) }
    }

    @TypeConverter
    fun toTemp(data: String?): Temp? {
        return data?.let { GsonManager.fromJson(it, Temp::class.java) }
    }

    @TypeConverter
    fun toJson(data: Weather?): String? {
        return data?.let { GsonManager.toJson(it) }
    }

    @TypeConverter
    fun toWeather(data: String?): List<Weather>? {
        return data?.let { GsonManager.fromJson(it, getTypeToken<List<Weather>>()) }
    }
}