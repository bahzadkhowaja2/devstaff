package com.devstaff.farmcollector.repository;

import com.devstaff.farmcollector.model.Field;
import com.devstaff.farmcollector.model.Harvest;
import com.devstaff.farmcollector.model.enumeration.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestedRepository extends JpaRepository<Harvest, Long> {

    List<Harvest> findByField(Field field);

    List<Harvest> findBySeason(Season season);

}
