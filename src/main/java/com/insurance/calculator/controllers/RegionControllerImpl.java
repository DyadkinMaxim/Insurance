package com.insurance.calculator.controllers;

import com.insurance.calculator.rest.NotFoundException;
import com.insurance.calculator.dao.RegionRepository;
import com.insurance.calculator.domain.Region;
import com.insurance.calculator.service.RegionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RegionControllerImpl implements RegionController {

    private final RegionRepository regionRepository;
    private final RegionService regionService;

    public RegionControllerImpl(RegionRepository regionRepository,
                                   RegionService regionService) {
        this.regionRepository = regionRepository;
        this.regionService = regionService;
    }

    @GetMapping("/management/regions")
    public List<Region> getAllRegions() {
        return new ArrayList<>(regionRepository.findAll());
    }

    @DeleteMapping("management/region/{id}")
    public void deleteRegion(@PathVariable(value = "id") long id) {
        regionRepository.deleteById(id);
    }

    @PutMapping("/management/region/{id}")
    @ExceptionHandler(NotFoundException.class)
    public void updateRegion(
            @RequestBody Region region
    ) {
        regionService.update(region);
    }


    @PostMapping("/management/region/newRegion")
    public void saveRegion(
            @RequestBody Region newRegion
    ) {
        regionService.save(newRegion);
    }
}