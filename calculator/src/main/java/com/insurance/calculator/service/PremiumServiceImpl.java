package com.insurance.calculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.insurance.calculator.controllers.NotFoundException;
import com.insurance.calculator.domain.Premium;
import com.insurance.calculator.dto.PremiumDTO;
import com.insurance.calculator.dto.RegionDTO;
import com.insurance.calculator.dto.TypeClassDTO;
import com.insurance.calculator.repository.PremiumRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PremiumServiceImpl implements PremiumService {

    private final PremiumRepository premiumRepository;
    private final ModelMapper modelMapper;

    public PremiumServiceImpl(PremiumRepository premiumRepository,
                              ModelMapper modelMapper) {
        this.premiumRepository = premiumRepository;
        this.modelMapper = modelMapper;
    }

    public List<PremiumDTO> getAllPremiums() {
        return premiumRepository.findAll().stream().map(
                premium -> modelMapper.map(premium, PremiumDTO.class))
                .collect(Collectors.toList());
    }

    public PremiumDTO getPremiumByID(long id) {
        return modelMapper.map(premiumRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No premiums found with id " + id)), PremiumDTO.class);
    }

    @Transactional
    public PremiumDTO savePremium(Long mileage, String typeClassName, long postCode) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        var restTemplate = new RestTemplate();

        var typeClassDTO = mapper.readValue(
                restTemplate.getForEntity("http://localhost:8081/management/typeClasses/" + typeClassName, String.class)
                        .getBody(), TypeClassDTO.class);
        var regionDTO = mapper.readValue(
                restTemplate.getForEntity("http://localhost:8081/management/regions/" + postCode, String.class)
                        .getBody(), RegionDTO.class);


        var milleageFactor = getMileageFactor(mileage);
        var premiumValue = milleageFactor * typeClassDTO.getFactorValue() * regionDTO.getFactorValue();

        var newPremium = new Premium();
        newPremium.setMileageFactor(milleageFactor);
        newPremium.setRegionalFactorId(regionDTO.getId());
        newPremium.setTypeClassFactorId(typeClassDTO.getId());
        newPremium.setPremiumValue(premiumValue);
        var saved = premiumRepository.save(newPremium);
        return modelMapper.map(saved, PremiumDTO.class);
    }

    public Double getMileageFactor(long mileage) {
        if (mileage < 5000) {
            return 0.5;
        } else if (mileage < 10000) {
            return 1.0;
        } else if (mileage < 20000) {
            return 1.5;
        } else {
            return 2.0;
        }
    }
}
