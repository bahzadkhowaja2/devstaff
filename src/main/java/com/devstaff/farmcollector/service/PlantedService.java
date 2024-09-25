package com.devstaff.farmcollector.service;

import com.devstaff.farmcollector.model.Plant;

public interface PlantedService {

    Plant savePlanted(Plant plant);

    Plant getById(Long id);
}
