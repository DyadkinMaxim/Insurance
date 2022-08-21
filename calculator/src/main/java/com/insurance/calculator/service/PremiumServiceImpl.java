package com.insurance.calculator.service;


import com.insurance.calculator.controllers.NotFoundException;
import com.insurance.calculator.repository.PremiumRepository;
import com.insurance.calculator.domain.Premium;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PremiumServiceImpl implements PremiumService {

    private final PremiumRepository premiumRepository;
    public PremiumServiceImpl(PremiumRepository premiumRepository) {
        this.premiumRepository = premiumRepository;
    }

    public List<Premium> getAllPremiums() {
        return premiumRepository.findAll();
    }

    public Premium getPremiumByID(long id) {
        return premiumRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Premium savePremium(Long mileage, String typeClassName, long postCode) {
        //var typeClass = typeClassRepository.findByClassNameContains(typeClassName);

        var restTemplate = new RestTemplate();
        var typeClass
                = restTemplate.getForEntity("http://localhost:8081/management/typeClasses/" + typeClassName, String.class);



        var milleageFactor = getMileageFactor(mileage);
       // var premiumValue = milleageFactor * typeClass. * region.getFactorValue();

        var newPremium = new Premium();
        newPremium.setMileageFactor(milleageFactor);
       // newPremium.setRegionalFactorId(region.getId());
        //newPremium.setTypeClassFactorId(typeClass.getId());
        //newPremium.setPremiumValue(premiumValue);
        var saved =  premiumRepository.save(newPremium);
        return saved;
    }

    public Double getMileageFactor(long mileage) {
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
