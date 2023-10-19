package com.gis.team.service;

import com.gis.team.model.MushroomLocation;

import java.math.BigDecimal;
import java.util.Map;

public class GeoJsonConverter {

    private GeoJsonConverter() {
        // Prevent instantiation
        throw new IllegalStateException("Utility class");
    }

    public static Map<String, Object> toGeoJson(MushroomLocation location) {
        return Map.of(
                "type", "Feature",
                "geometry", Map.of(
                        "type", "Point",
                        "coordinates", new BigDecimal[]{location.getX(), location.getY()}
                ),
                "properties", Map.of(
                        "name", location.getName(),
                        "description", location.getDescription()
                )
        );
    }

    public static MushroomLocation fromGeoJson(Map<String, Object> geoJson) {
        Map<String, Object> geometry = (Map<String, Object>) geoJson.get("geometry");
        BigDecimal[] coordinates = (BigDecimal[]) geometry.get("coordinates");
        Map<String, Object> properties = (Map<String, Object>) geoJson.get("properties");
        return new MushroomLocation(
                (String) properties.get("name"),
                coordinates[0],
                coordinates[1],
                (String) properties.get("description")
        );
    }
}
