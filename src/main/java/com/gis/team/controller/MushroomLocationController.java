package com.gis.team.controller;

import com.gis.team.model.MushroomLocation;
import com.gis.team.service.MushroomLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mushroom-locations")
public class MushroomLocationController {

    @Autowired
    private MushroomLocationService locationService;


    @Autowired
    private MushroomLocationService service;

    @GetMapping
    public ResponseEntity<List<MushroomLocation>> getAllLocations() {
        return ResponseEntity.ok(service.getAllLocations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MushroomLocation> getLocationById(@PathVariable Integer id) {
        Optional<MushroomLocation> locationOpt = locationService.getLocationById(id);
        if (!locationOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(locationOpt.get());
    }

    @GetMapping("/search")
    public ResponseEntity<List<MushroomLocation>> getLocationByName(@RequestParam String name) {
        return ResponseEntity.ok(service.getLocationByName(name));
    }

    @PostMapping
    public ResponseEntity<MushroomLocation> addLocation(@RequestBody MushroomLocation location) {
        return ResponseEntity.ok(service.addLocation(location));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MushroomLocation> updateLocation(@PathVariable Integer id, @RequestBody MushroomLocation location) {
        location.setId(id); // Ensuring the ID from the path variable is set on the location to update
        return ResponseEntity.ok(service.updateLocation(location));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocation(@PathVariable Integer id) {
        service.deleteLocation(id);
        return ResponseEntity.noContent().build();
    }
}
