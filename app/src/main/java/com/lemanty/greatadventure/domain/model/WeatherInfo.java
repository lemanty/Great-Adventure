package com.lemanty.greatadventure.domain.model;

import java.util.Objects;
import androidx.annotation.Nullable;

/** Immutable value model; compare by field values. */
public final class WeatherInfo {
    private final WeatherCondition condition;
    @Nullable
    private final Double temperatureCelsius;
    private final long observedAtEpochMillis;

    public WeatherInfo(WeatherCondition condition, @Nullable Double temperatureCelsius, long observedAtEpochMillis) {
        this.condition = Objects.requireNonNull(condition);
        this.temperatureCelsius = temperatureCelsius;
        this.observedAtEpochMillis = observedAtEpochMillis;
    }

    public WeatherCondition getCondition() { return condition; }

    @Nullable
    public Double getTemperatureCelsius() { return temperatureCelsius; }

    public long getObservedAtEpochMillis() { return observedAtEpochMillis; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WeatherInfo)) return false;
        WeatherInfo other = (WeatherInfo) obj;
        return Objects.equals(condition, other.condition)
                && Objects.equals(temperatureCelsius, other.temperatureCelsius)
                && observedAtEpochMillis == other.observedAtEpochMillis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, temperatureCelsius, observedAtEpochMillis);
    }

    @Override
    public String toString() {
        return "WeatherInfo{" + "condition=" + condition + ", " + "temperatureCelsius=" + temperatureCelsius + ", " + "observedAtEpochMillis=" + observedAtEpochMillis + "}";
    }
}
