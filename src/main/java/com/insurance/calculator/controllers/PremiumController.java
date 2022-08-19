package com.insurance.calculator.controllers;

import com.insurance.calculator.domain.Region;
import com.insurance.calculator.domain.TypeClass;

import java.util.List;

public interface PremiumController {

    List<Region> getAllRegions();

    Region getRegionByID();

    void calculatePremium(long mileage, TypeClass typeClass, long postCode);
}
