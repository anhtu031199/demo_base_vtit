package com.tuna.nothingapp.data.remote.request

import com.google.gson.annotations.SerializedName
import com.tuna.nothingapp.utils.Constants

data class WeatherRequestBody(
    var lat: Double = 0.0,
    var lon: Double = 0.0,
    var units: String = "metric",
    @SerializedName("appid")
    var appID: String = Constants.APPID
)