package com.devstaff.farmcollector;

import com.devstaff.farmcollector.dto.ReportDTO;
import com.devstaff.farmcollector.model.Harvest;
import com.devstaff.farmcollector.model.Plant;
import com.devstaff.farmcollector.model.enumeration.Season;
import com.devstaff.farmcollector.repository.FarmRepository;
import com.devstaff.farmcollector.repository.FieldRepository;
import com.devstaff.farmcollector.repository.HarvestedRepository;
import com.devstaff.farmcollector.repository.PlantedRepository;
import com.devstaff.farmcollector.service.impl.ReportServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ReportServiceTest {

    @Mock
    private PlantedRepository plantedRepository;

    @Mock
    private HarvestedRepository harvestedRepository;

    @Mock
    private FarmRepository farmRepository;

    @Mock
    private FieldRepository fieldRepository;

    @InjectMocks
    private ReportServiceImpl reportService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetSeasonReport_WithValidData() {
        // Mock data for planted and harvested
        Plant plant1 = new Plant();
        plant1.setExpectedAmount(100.0);
        Plant plant2 = new Plant();
        plant2.setExpectedAmount(150.0);

        Harvest harvest1 = new Harvest();
        harvest1.setActualAmount(120.0);
        Harvest harvest2 = new Harvest();
        harvest2.setActualAmount(130.0);

        // Mock repository calls
        when(plantedRepository.findBySeason(Season.SPRING)).thenReturn(List.of(plant1, plant2));
        when(harvestedRepository.findBySeason(Season.SPRING)).thenReturn(List.of(harvest1, harvest2));

        // Call the service method
        ReportDTO report = reportService.getSeasonReport(Season.SPRING);

        // Assertions
        assertEquals(250.0, report.getExpectedAmount());
        assertEquals(250.0, report.getActualAmount());
    }

    @Test
    void testGetSeasonReport_WithNoData() {
        // Mock repository calls with empty lists
        when(plantedRepository.findBySeason(Season.SPRING)).thenReturn(Collections.emptyList());
        when(harvestedRepository.findBySeason(Season.SPRING)).thenReturn(Collections.emptyList());

        // Call the service method
        ReportDTO report = reportService.getSeasonReport(Season.SPRING);

        // Assertions
        assertEquals(0.0, report.getExpectedAmount());
        assertEquals(0.0, report.getActualAmount());
    }
}
