package com.insurance.calculator.service;

import com.insurance.calculator.controllers.NotFoundException;
import com.insurance.calculator.dao.PremiumRepository;
import com.insurance.calculator.dao.RegionRepository;
import com.insurance.calculator.dao.TypeClassRepository;
import com.insurance.calculator.domain.Premium;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremiumServiceImpl implements PremiumService {

    private final PremiumRepository premiumRepository;
    private final RegionRepository regionRepository;
    private final TypeClassRepository typeClassRepository;

    public PremiumServiceImpl(PremiumRepository premiumRepository,
                              RegionRepository regionRepository,
                              TypeClassRepository typeClassRepository
    ) {
        this.premiumRepository = premiumRepository;
        this.regionRepository = regionRepository;
        this.typeClassRepository = typeClassRepository;
    }

    public List<Premium> getAllPremiums() {
        return premiumRepository.findAll();
    }

    public Premium getPremiumByID(long id) {
        return premiumRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Premium savePremium(Long mileage, String typeClassName, long postCode) {
        var typeClass = typeClassRepository.findByClassName(typeClassName);
        var region = regionRepository.findByPostCode(postCode);
        var milleageFactor = getMileageFactor(mileage);
        var premiumValue = milleageFactor * typeClass.getFactorValue() * region.getFactorValue();

        var newPremium = new Premium();
        newPremium.setMileageFactor(milleageFactor);
        newPremium.setRegionalFactorId(region.getId());
        newPremium.setTypeClassFactorId(typeClass.getId());
        newPremium.setPremiumValue(premiumValue);
        return premiumRepository.save(newPremium);
    }

    public double getMileageFactor(long mileage) {
        if(mileage < 5000) {
            return 0.5;
        }
        else if(mileage < 10000) {
            return 1.0;
        }
        else if(mileage < 20000) {
            return 1.5;
        }
        else {
            return 2.0;
        }
    }
}
