package com.devstaff.farmcollector;

import com.devstaff.farmcollector.model.Plant;
import com.devstaff.farmcollector.repository.PlantedRepository;
import com.devstaff.farmcollector.service.impl.PlantedServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PlantedServiceTest {

    private PlantedServiceImpl plantedService;
    private PlantedRepository plantedRepository;

    @BeforeEach
    void setUp() {
        plantedRepository = mock(PlantedRepository.class);
        plantedService = new PlantedServiceImpl(plantedRepository);
    }

    @Test
    void testSavePlanted() {
        // Arrange
        Plant plant = new Plant();
        plant.setId(1L); // Set other properties as needed

        when(plantedRepository.save(plant)).thenReturn(plant);

        // Act
        Plant savedPlant = plantedService.savePlanted(plant);

        // Assert
        assertEquals(plant, savedPlant);
        verify(plantedRepository, times(1)).save(plant); // Verify that save was called once
    }

    @Test
    void testGetByIdExists() {
        // Arrange
        Plant plant = new Plant();
        plant.setId(1L); // Set other properties as needed

        when(plantedRepository.findById(1L)).thenReturn(java.util.Optional.of(plant));

        // Act
        Plant foundPlant = plantedService.getById(1L);

        // Assert
        assertEquals(plant, foundPlant);
        verify(plantedRepository, times(1)).findById(1L); // Verify that findById was called once
    }

    @Test
    void testGetByIdNotExists() {
        // Arrange
        when(plantedRepository.findById(1L)).thenReturn(java.util.Optional.empty());

        // Act
        Plant foundPlant = plantedService.getById(1L);

        // Assert
        assertEquals(null, foundPlant);
        verify(plantedRepository, times(1)).findById(1L); // Verify that findById was called once
    }
}
