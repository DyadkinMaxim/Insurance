package com.insurance.calculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.insurance.calculator.dto.PremiumDTO;

import java.util.List;

public interface PremiumService {
    List<PremiumDTO> getAllPremiums();

    PremiumDTO getPremiumByID(long id);

    PremiumDTO savePremium(Long mileage, String typeClassName, long postCode) throws JsonProcessingException;

    Double getMileageFactor(long mileage);
}
