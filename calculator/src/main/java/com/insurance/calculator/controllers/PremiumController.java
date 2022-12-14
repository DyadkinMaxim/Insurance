package com.insurance.calculator.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.insurance.calculator.dto.PremiumDTO;
import com.insurance.calculator.dto.UserEntryDTO;

import java.util.List;

public interface PremiumController {

    List<PremiumDTO> getAllPremiums();

    PremiumDTO getPremiumByID(long id);

    PremiumDTO savePremium(UserEntryDTO userEntryDTO) throws JsonProcessingException;
}
