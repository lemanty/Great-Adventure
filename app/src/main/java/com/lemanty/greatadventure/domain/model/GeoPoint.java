package com.lemanty.greatadventure.domain.model;

import java.util.Objects;

/** Immutable value model; compare by field values. */
public final class GeoPoint {
    private final double latitude;
    private final double longitude;
    private final CoordinateSystem coordinateSystem;

    public GeoPoint(double latitude, double longitude, CoordinateSystem coordinateSystem) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.coordinateSystem = Objects.requireNonNull(coordinateSystem);
    }

    public double getLatitude() { return latitude; }

    public double getLongitude() { return longitude; }

    public CoordinateSystem getCoordinateSystem() { return coordinateSystem; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof GeoPoint)) return false;
        GeoPoint other = (GeoPoint) obj;
        return Double.compare(latitude, other.latitude) == 0
                && Double.compare(longitude, other.longitude) == 0
                && Objects.equals(coordinateSystem, other.coordinateSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude, coordinateSystem);
    }

    @Override
    public String toString() {
        return "GeoPoint{" + "latitude=" + latitude + ", " + "longitude=" + longitude + ", " + "coordinateSystem=" + coordinateSystem + "}";
    }
}
