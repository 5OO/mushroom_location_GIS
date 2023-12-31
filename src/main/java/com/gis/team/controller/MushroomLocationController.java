package com.gis.team.controller;

import com.gis.team.model.MushroomLocation;
import com.gis.team.service.GeoJsonConverter;
import com.gis.team.service.MushroomLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mushroom-locations")
public class MushroomLocationController {

    @Autowired
    private MushroomLocationService locationService;


    @Autowired
    private MushroomLocationService service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<Map<String, Object>> getAllLocations() {
        List<MushroomLocation> mushroomLocationList = service.getAllLocations();

        List<Map<String , Object>> features = mushroomLocationList.stream()
                .map(location -> GeoJsonConverter.toGeoJson(location))
                .collect(Collectors.toList());

        Map<String, Object> featureCollection = new HashMap<>();
        featureCollection.put("type", "FeatureCollection");
        featureCollection.put("features", features);
        return ResponseEntity.ok(featureCollection);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getLocationById(@PathVariable Integer id) {
        Optional<MushroomLocation> locationOpt = locationService.getLocationById(id);
        if (!locationOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(GeoJsonConverter.toGeoJson(locationOpt.get()) );
    }

    @GetMapping("/search")
    public ResponseEntity<Map<String, Object>> getLocationByName(@RequestParam String name) {
        List<MushroomLocation> mushroomLocationList = service.getLocationByName(name);

        List<Map<String , Object>> features = mushroomLocationList.stream()
                .map(location -> GeoJsonConverter.toGeoJson(location))
                .collect(Collectors.toList());

        Map<String, Object> featureCollection = new HashMap<>();
        featureCollection.put("type", "FeatureCollection");
        featureCollection.put("features", features);
        return ResponseEntity.ok(featureCollection);
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> addLocation(@RequestBody MushroomLocation location) {
        return ResponseEntity.ok(GeoJsonConverter.toGeoJson(service.addLocation(location)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateLocation(@PathVariable Integer id, @RequestBody MushroomLocation location) {
        location.setId(id); // Ensuring the ID from the path variable is set on the location to update
        return ResponseEntity.ok(GeoJsonConverter.toGeoJson(service.updateLocation(location)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Integer id) {
        service.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
}
