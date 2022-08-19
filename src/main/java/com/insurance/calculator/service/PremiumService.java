package com.insurance.calculator.service;

import com.insurance.calculator.domain.Premium;
import com.insurance.calculator.domain.Region;
import com.insurance.calculator.domain.TypeClass;

import java.util.List;

public interface PremiumService {
    List<Premium> getAllPremiums();

    Premium getPremiumByID(long id);

    Premium savePremium(Long mileage, String typeClassName, long postCode);

}
