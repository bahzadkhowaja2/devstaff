package com.devstaff.farmcollector.controller;

import com.devstaff.farmcollector.model.Harvest;
import com.devstaff.farmcollector.service.HarvestedService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/harvested")
public class HarvestedController {

    private final HarvestedService harvestedService;

    public HarvestedController(HarvestedService harvestedService) {
        this.harvestedService = harvestedService;
    }

    @PostMapping("")
    public ResponseEntity<Harvest> saveHarvested(@RequestBody Harvest harvest) {

        Harvest savedHarvest = harvestedService.saveHarvested(harvest);
        return ResponseEntity.ok(savedHarvest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Harvest> getById(@PathVariable Long id) {
        Harvest harvest = harvestedService.getById(id);
        return ResponseEntity.ok(harvest);
    }
}
