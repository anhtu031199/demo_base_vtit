package com.tuna.nothingapp.data.remote.request

import com.google.gson.annotations.SerializedName
import com.tuna.nothingapp.BuildConfig

data class CurrentLocationRequestBody(
    var at: String,
    @SerializedName("apiKey")
    var apiKey: String = BuildConfig.WEATHER_KEY
)