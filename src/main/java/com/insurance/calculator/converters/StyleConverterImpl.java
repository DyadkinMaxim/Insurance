package com.insurance.calculator.converters;

import com.insurance.calculator.dto.StyleDTO;
import com.insurance.calculator.models.Style;
import org.springframework.stereotype.Service;

@Service
public class StyleConverterImpl implements  StyleConverter{

    public StyleDTO toDTO(Style style) {
        return new StyleDTO(
                style.getId(),
                style.getStyleName()
        );
    }
}
