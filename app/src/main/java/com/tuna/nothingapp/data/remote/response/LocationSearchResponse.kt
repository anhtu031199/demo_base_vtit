package com.tuna.nothingapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class LocationSearchResponse(
    @SerializedName("items") val items: List<Item>
)

data class Item(
    @SerializedName("address") val address: Address,
    @SerializedName("id") val id: String,
    @SerializedName("mapView") val mapView: MapView,
    @SerializedName("position") val position: Position,
    @SerializedName("resultType") val resultType: String,
    @SerializedName("scoring") val scoring: Scoring,
    @SerializedName("title") val title: String
)

data class Address(
    @SerializedName("city") val city: String,
    @SerializedName("countryCode") val countryCode: String,
    @SerializedName("countryName") val countryName: String,
    @SerializedName("county") val county: String,
    @SerializedName("district") val district: String,
    @SerializedName("label") val label: String,
    @SerializedName("postalCode") val postalCode: String,
    @SerializedName("street") val street: String
)

data class FieldScore(
    @SerializedName("streets") val streets: List<Double>
)

data class MapView(
    @SerializedName("east") val east: Double,
    @SerializedName("north") val north: Double,
    @SerializedName("south") val south: Double,
    @SerializedName("west") val west: Double
)

data class Position(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)

data class Scoring(
    @SerializedName("fieldScore") val fieldScore: FieldScore,
    @SerializedName("queryScore") val queryScore: Double
)