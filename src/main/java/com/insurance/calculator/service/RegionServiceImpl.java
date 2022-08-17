package com.insurance.calculator.service;

import com.insurance.calculator.domain.Region;
import com.insurance.calculator.rest.NotFoundException;
import com.insurance.calculator.dao.RegionRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;

    public RegionServiceImpl(RegionRepository regionRepository){
        this.regionRepository = regionRepository;
    }

    @Transactional
    public Region save(@NonNull Region newRegion) {
        regionRepository.save(newRegion);
        return newRegion;
    }

    @Transactional
    public void update(@NonNull Region region) {
        Region savedRegion = regionRepository.findById(region.getId()).orElseThrow(NotFoundException::new);
        savedRegion.setFederalState(region.getFederalState());
        savedRegion.setCounty(region.getCounty());
        savedRegion.setCity(region.getCity());
        savedRegion.setLocation(region.getLocation());
        savedRegion.setFactorValue(region.getFactorValue());
    }
}
