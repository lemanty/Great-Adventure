package com.lemanty.greatadventure.data.repository

import com.lemanty.greatadventure.domain.model.GeoPoint
import com.lemanty.greatadventure.domain.model.Place

interface PlaceRepository {
    /** Empty results are Success(emptyList()). Implementations must preserve cancellation. */
    suspend fun searchNearby(location: GeoPoint, radiusMeters: Int): FetchResult<List<Place>>
}
