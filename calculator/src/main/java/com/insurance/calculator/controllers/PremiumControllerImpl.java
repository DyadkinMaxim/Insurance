package com.insurance.calculator.controllers;

import com.insurance.calculator.domain.Premium;
import com.insurance.calculator.service.PremiumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PremiumControllerImpl implements  PremiumController{

    private final PremiumService premiumService;

    public PremiumControllerImpl(PremiumService premiumService) {

        this.premiumService = premiumService;
    }

    @GetMapping("/management/premiums")
    public List<Premium> getAllPremiums() {
        return premiumService.getAllPremiums();
    }

    @GetMapping("/management/premiums/{id}")
    public Premium getPremiumByID(@PathVariable(value = "id") long id){
        return premiumService.getPremiumByID(id);
    }

    @PostMapping("/management/premium/newPremium")
    public void savePremium(Long mileage, String typeClassName, long postCode){
        premiumService.savePremium(mileage, typeClassName, postCode);
    }
}
