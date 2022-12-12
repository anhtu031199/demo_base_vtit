package com.tuna.nothingapp.data.remote.response

data class LocationSuggestResponse(
    val items: List<Item>
)

data class Item(
    val address: Address,
    val id: String,
    val mapView: MapView,
    val position: Position,
    val resultType: String,
    val scoring: Scoring,
    val title: String
)

data class Address(
    val city: String,
    val countryCode: String,
    val countryName: String,
    val county: String,
    val district: String,
    val label: String,
    val postalCode: String,
    val street: String
)

data class FieldScore(
    val streets: List<Double>
)

data class MapView(
    val east: Double,
    val north: Double,
    val south: Double,
    val west: Double
)

data class Position(
    val lat: Double,
    val lng: Double
)

data class Scoring(
    val fieldScore: FieldScore,
    val queryScore: Double
)