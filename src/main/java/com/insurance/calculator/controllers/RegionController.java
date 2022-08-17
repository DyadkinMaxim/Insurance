package com.insurance.calculator.controllers;

import com.insurance.calculator.domain.Region;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RegionController {

    List<Region> getAllRegions();

    void deleteRegion(long id);

    void updateRegion( @RequestBody Region typeClass);

    void saveRegion(@RequestBody Region region);
}
