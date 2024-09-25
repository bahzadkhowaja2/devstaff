package com.devstaff.farmcollector.controller;

import com.devstaff.farmcollector.dto.ReportDTO;
import com.devstaff.farmcollector.model.enumeration.Season;
import com.devstaff.farmcollector.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/report")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    @GetMapping("/{season}")
    public ReportDTO generateSeasonReport(@PathVariable Season season) {
        return reportService.getSeasonReport(season);
    }
}
