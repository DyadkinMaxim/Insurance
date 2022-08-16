package com.insurance.calculator.rest;

import com.insurance.calculator.converters.StyleConverterImpl;
import com.insurance.calculator.dto.StyleDTO;
import com.insurance.calculator.repositoriesSpringDataJPA.StyleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StyleController {
    private final StyleRepository styleRepository;
    private final StyleConverterImpl styleConverterImpl;

    public StyleController(StyleRepository styleRepository, StyleConverterImpl styleConverterImpl) {
        this.styleRepository = styleRepository;
        this.styleConverterImpl = styleConverterImpl;
    }

    @GetMapping("/api/styles")
    public List<StyleDTO> getAllStyles() {
        return styleRepository.findAll().stream().map(styleConverterImpl::toDTO)
                .collect(Collectors.toList());
    }
}
