package com.devstaff.farmcollector.repository;

import com.devstaff.farmcollector.model.Field;
import com.devstaff.farmcollector.model.Plant;
import com.devstaff.farmcollector.model.enumeration.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantedRepository extends JpaRepository<Plant, Long> {

    List<Plant> findByField(Field field);

    List<Plant> findBySeason(Season season);
}
