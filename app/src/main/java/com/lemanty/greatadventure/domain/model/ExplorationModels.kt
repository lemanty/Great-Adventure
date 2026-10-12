package com.lemanty.greatadventure.domain.model

enum class CoordinateSystem { WGS84, GCJ02 }

// Convert at service boundaries; never compare different coordinate systems.
data class GeoPoint(
    val latitude: Double,
    val longitude: Double,
    val coordinateSystem: CoordinateSystem,
)

enum class PlaceCategory { CAFE, PARK, CULTURE, OTHER }

data class Place(
    val id: String,
    val name: String,
    val location: GeoPoint,
    val category: PlaceCategory,
)

enum class WeatherCondition { CLEAR, CLOUDY, RAIN, SNOW, UNKNOWN }

data class WeatherInfo(
    val condition: WeatherCondition,
    val temperatureCelsius: Double?,
    val observedAtEpochMillis: Long,
)
