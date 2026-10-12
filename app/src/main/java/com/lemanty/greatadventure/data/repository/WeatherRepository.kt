package com.lemanty.greatadventure.data.repository

import com.lemanty.greatadventure.domain.model.GeoPoint
import com.lemanty.greatadventure.domain.model.WeatherInfo

interface WeatherRepository {
    /** Map provider fields and preserve coroutine cancellation in implementations. */
    suspend fun getCurrentWeather(location: GeoPoint): FetchResult<WeatherInfo>
}
