package com.lemanty.greatadventure.domain.model;

import java.util.Objects;

/** Immutable value model; compare by field values. */
public final class Place {
    private final String id;
    private final String name;
    private final GeoPoint location;
    private final PlaceCategory category;

    public Place(String id, String name, GeoPoint location, PlaceCategory category) {
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.location = Objects.requireNonNull(location);
        this.category = Objects.requireNonNull(category);
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public GeoPoint getLocation() { return location; }

    public PlaceCategory getCategory() { return category; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Place)) return false;
        Place other = (Place) obj;
        return Objects.equals(id, other.id)
                && Objects.equals(name, other.name)
                && Objects.equals(location, other.location)
                && Objects.equals(category, other.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, location, category);
    }

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", " + "name=" + name + ", " + "location=" + location + ", " + "category=" + category + "}";
    }
}
