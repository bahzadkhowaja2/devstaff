package com.devstaff.farmcollector.service.impl;

import com.devstaff.farmcollector.model.Field;
import com.devstaff.farmcollector.model.Harvest;
import com.devstaff.farmcollector.repository.FieldRepository;
import com.devstaff.farmcollector.repository.HarvestedRepository;
import com.devstaff.farmcollector.service.HarvestedService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HarvestedServiceImpl implements HarvestedService {

    private final HarvestedRepository harvestedRepository;

    private final FieldRepository fieldRepository;

    public HarvestedServiceImpl(HarvestedRepository harvestedRepository, FieldRepository fieldRepository) {
        this.harvestedRepository = harvestedRepository;
        this.fieldRepository = fieldRepository;
    }

    @Override
    public Harvest saveHarvested(Harvest harvest) {
        return harvestedRepository.save(harvest);
    }

    @Override
    public Harvest getById(Long id) {
        return harvestedRepository.findById(id).orElse(null);
    }
}
