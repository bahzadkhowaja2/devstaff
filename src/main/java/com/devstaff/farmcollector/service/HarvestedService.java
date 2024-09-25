package com.devstaff.farmcollector.service;

import com.devstaff.farmcollector.model.Harvest;

public interface HarvestedService {

    Harvest saveHarvested(Harvest harvest);

    Harvest getById(Long id);
}
