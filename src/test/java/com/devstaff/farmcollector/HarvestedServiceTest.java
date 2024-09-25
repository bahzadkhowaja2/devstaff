package com.devstaff.farmcollector;

import com.devstaff.farmcollector.model.Harvest;
import com.devstaff.farmcollector.repository.HarvestedRepository;
import com.devstaff.farmcollector.service.impl.HarvestedServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class HarvestedServiceTest {

    private HarvestedServiceImpl harvestedService;
    private HarvestedRepository harvestedRepository;

    @BeforeEach
    void setUp() {
        harvestedRepository = mock(HarvestedRepository.class);
        harvestedService = new HarvestedServiceImpl(harvestedRepository, null);
    }

    @Test
    void testSaveHarvested() {
        // Arrange
        Harvest harvest = new Harvest();
        harvest.setId(1L);  // Set other properties as needed

        when(harvestedRepository.save(harvest)).thenReturn(harvest);

        // Act
        Harvest savedHarvest = harvestedService.saveHarvested(harvest);

        // Assert
        assertEquals(harvest, savedHarvest);
        verify(harvestedRepository, times(1)).save(harvest); // Verify that save was called once
    }

}
