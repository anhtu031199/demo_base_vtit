package com.tuna.nothingapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location")
data class Location(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val isCurrentLocate: Boolean? = false,
    val name: String? = null,
    val temp: Int? = null,
    val minTemp: Int? = null,
    val maxTemp: Int? = null,
    val main: String? = null,
    val icon: String? = null,
    val lat: Double? = null,
    val lon: Double? = null
)