package com.lemanty.greatadventure.data.repository;

import com.lemanty.greatadventure.domain.model.GeoPoint;
import com.lemanty.greatadventure.domain.model.WeatherInfo;

public interface WeatherRepository {
    /**
     * Start an asynchronous request without blocking the caller.
     * Implementations map provider fields, deliver on the main thread,
     * and honor cancellation through the returned handle.
     */
    RequestHandle getCurrentWeather(GeoPoint location,
            RepositoryCallback<WeatherInfo> callback);
}
