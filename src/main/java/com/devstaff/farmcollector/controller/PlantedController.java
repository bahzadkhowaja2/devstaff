package com.devstaff.farmcollector.controller;

import com.devstaff.farmcollector.model.Harvest;
import com.devstaff.farmcollector.model.Plant;
import com.devstaff.farmcollector.service.HarvestedService;
import com.devstaff.farmcollector.service.PlantedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planted")
public class PlantedController {

    private final PlantedService plantedService;

    public PlantedController(PlantedService plantedService) {
        this.plantedService = plantedService;
    }

    @PostMapping("")
    public ResponseEntity<Plant> savePlanted(@RequestBody Plant plant) {

        Plant savedPlant = plantedService.savePlanted(plant);
        return ResponseEntity.ok(savedPlant);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plant> getById(@PathVariable Long id) {
        Plant plant = plantedService.getById(id);
        return ResponseEntity.ok(plant);
    }
}
