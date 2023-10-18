package com.gis.team.repository;

import com.gis.team.model.MushroomLocation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MushroomLocationRepository extends JpaRepository <MushroomLocation, Integer> {

    List<MushroomLocation> findByName(String name);

}
