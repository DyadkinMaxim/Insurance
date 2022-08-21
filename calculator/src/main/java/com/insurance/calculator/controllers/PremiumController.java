package com.insurance.calculator.controllers;

import com.insurance.calculator.domain.Premium;
import com.insurance.calculator.dto.PremiumDTO;

import java.util.List;

public interface PremiumController {

    List<PremiumDTO> getAllPremiums();

    PremiumDTO getPremiumByID(long id);

    PremiumDTO savePremium(Long mileage, String typeClassName, long postCode);
}
