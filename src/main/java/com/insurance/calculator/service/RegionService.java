package com.insurance.calculator.service;

import com.insurance.calculator.domain.Region;

public interface RegionService {
    Region save(Region region);

    void update(Region region);
}
