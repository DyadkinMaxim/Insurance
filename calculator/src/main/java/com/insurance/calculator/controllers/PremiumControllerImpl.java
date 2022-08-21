package com.insurance.calculator.controllers;

import com.insurance.calculator.dto.PremiumDTO;
import com.insurance.calculator.service.PremiumService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PremiumControllerImpl implements  PremiumController{

    private final PremiumService premiumService;

    public PremiumControllerImpl(PremiumService premiumService) {
        this.premiumService = premiumService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/management/premiums")
    public List<PremiumDTO> getAllPremiums() {
        return premiumService.getAllPremiums();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/management/premiums/{id}")
    public PremiumDTO getPremiumByID(@PathVariable(value = "id") long id){
        return premiumService.getPremiumByID(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/management/premium/newPremium")
    public PremiumDTO savePremium(Long mileage, String typeClassName, long postCode){
        return premiumService.savePremium(mileage, typeClassName, postCode);
    }
}
