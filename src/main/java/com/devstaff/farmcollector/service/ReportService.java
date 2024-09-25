package com.devstaff.farmcollector.service;

import com.devstaff.farmcollector.dto.ReportDTO;
import com.devstaff.farmcollector.model.enumeration.Season;

public interface ReportService {

    ReportDTO getSeasonReport(Season season);
}
