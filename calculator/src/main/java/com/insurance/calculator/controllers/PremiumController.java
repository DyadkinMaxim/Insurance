package com.insurance.calculator.controllers;

import com.insurance.calculator.domain.Premium;

import java.util.List;

public interface PremiumController {

    List<Premium> getAllPremiums();

    Premium getPremiumByID(long id);

    void savePremium(Long mileage, String typeClassName, long postCode);
}
