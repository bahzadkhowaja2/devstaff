package com.devstaff.farmcollector.service.impl;

import com.devstaff.farmcollector.model.Plant;
import com.devstaff.farmcollector.repository.PlantedRepository;
import com.devstaff.farmcollector.service.PlantedService;
import org.springframework.stereotype.Service;


@Service
public class PlantedServiceImpl implements PlantedService {

    private final PlantedRepository plantedRepository;

    public PlantedServiceImpl(PlantedRepository plantedRepository) {
        this.plantedRepository = plantedRepository;
    }

    @Override
    public Plant savePlanted(Plant plant) {
        return plantedRepository.save(plant);
    }

    @Override
    public Plant getById(Long id) {
        return plantedRepository.findById(id).orElse(null);
    }
}
