package com.devstaff.farmcollector.service.impl;

import com.devstaff.farmcollector.dto.ReportDTO;
import com.devstaff.farmcollector.model.Harvest;
import com.devstaff.farmcollector.model.Plant;
import com.devstaff.farmcollector.model.enumeration.Season;
import com.devstaff.farmcollector.repository.FarmRepository;
import com.devstaff.farmcollector.repository.FieldRepository;
import com.devstaff.farmcollector.repository.HarvestedRepository;
import com.devstaff.farmcollector.repository.PlantedRepository;
import com.devstaff.farmcollector.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final PlantedRepository plantedRepository;

    private final HarvestedRepository harvestedRepository;

    private final FarmRepository farmRepository;

    private final FieldRepository fieldRepository;

    public ReportServiceImpl(PlantedRepository plantedRepository, HarvestedRepository harvestedRepository, FarmRepository farmRepository, FieldRepository fieldRepository) {
        this.plantedRepository = plantedRepository;
        this.harvestedRepository = harvestedRepository;
        this.farmRepository = farmRepository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public ReportDTO getSeasonReport(Season season) {

        ReportDTO reportDTO = new ReportDTO();

        try {
            List<Harvest> harvestData = harvestedRepository.findBySeason(season);
            List<Plant> plantData = plantedRepository.findBySeason(season);
            Double expectedAmount = plantData.stream().mapToDouble(Plant::getExpectedAmount).sum();
            Double actualAmount = harvestData.stream().mapToDouble(Harvest::getActualAmount).sum();

            reportDTO.setExpectedAmount(expectedAmount);
            reportDTO.setActualAmount(actualAmount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return reportDTO;
    }
}
