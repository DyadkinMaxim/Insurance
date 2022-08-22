package com.insurance.calculator.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.insurance.calculator.dto.PremiumDTO;
import com.insurance.calculator.dto.UserEntryDTO;
import com.insurance.calculator.service.PremiumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PremiumControllerImpl implements PremiumController {

    private final PremiumService premiumService;

    public PremiumControllerImpl(PremiumService premiumService) {
        this.premiumService = premiumService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/calculator/premiums")
    public List<PremiumDTO> getAllPremiums() {
        return premiumService.getAllPremiums();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/calculator/premiums/{id}")
    public PremiumDTO getPremiumByID(@PathVariable(value = "id") long id) {
        return premiumService.getPremiumByID(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/calculator/newPremium")
    public PremiumDTO savePremium(@RequestBody UserEntryDTO userEntryDTO) throws JsonProcessingException {
        return premiumService.savePremium(userEntryDTO.getMileage(), userEntryDTO.getTypeClassName(), userEntryDTO.getPostcode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Throwable ex) {
        // For any exceptions
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Throwable ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
