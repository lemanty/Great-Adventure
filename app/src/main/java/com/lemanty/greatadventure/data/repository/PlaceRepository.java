package com.lemanty.greatadventure.data.repository;

import com.lemanty.greatadventure.domain.model.GeoPoint;
import com.lemanty.greatadventure.domain.model.Place;
import java.util.List;

public interface PlaceRepository {
    /**
     * Start an asynchronous request without blocking the caller.
     * No matches is Success with an empty list, not a failure.
     * Implementations must deliver on the main thread and honor cancellation.
     */
    RequestHandle searchNearby(GeoPoint location, int radiusMeters,
            RepositoryCallback<List<Place>> callback);
}
