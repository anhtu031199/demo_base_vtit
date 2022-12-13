package com.tuna.nothingapp.data.remote.response

import com.google.gson.annotations.SerializedName

data class CurrentLocationResponse(
    @SerializedName("items")val items: List<CurrentItem>
)

data class CurrentItem(
    @SerializedName("access")val access: List<CurrentAccess>,
    @SerializedName("address")val address: CurrentAddress,
    @SerializedName("distance")val distance: Int,
    @SerializedName("houseNumberType")val houseNumberType: String,
    @SerializedName("id")val id: String,
    @SerializedName("mapView")val mapView: CurrentMapView,
    @SerializedName("position")val position: CurrentPosition,
    @SerializedName("resultType")val resultType: String,
    @SerializedName("title")val title: String
)

data class CurrentAddress(
    @SerializedName("city")val city: String,
    @SerializedName("countryCode")val countryCode: String,
    @SerializedName("countryName")val countryName: String,
    @SerializedName("county")val county: String,
    @SerializedName("district")val district: String,
    @SerializedName("houseNumber")val houseNumber: String,
    @SerializedName("label")val label: String,
    @SerializedName("postalCode")val postalCode: String,
    @SerializedName("street")val street: String
)

data class CurrentAccess(
    @SerializedName("lat")val lat: Double,
    @SerializedName("lng")val lng: Double
)

data class CurrentMapView(
    @SerializedName("east")val east: Double,
    @SerializedName("north")val north: Double,
    @SerializedName("south")val south: Double,
    @SerializedName("west")val west: Double
)

data class CurrentPosition(
    @SerializedName("lat")val lat: Double,
    @SerializedName("lng")val lng: Double
)