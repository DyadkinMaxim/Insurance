package com.insurance.calculator.converters;

import com.insurance.calculator.dto.StyleDTO;
import com.insurance.calculator.models.Style;

public interface StyleConverter {
    StyleDTO toDTO(Style style);
}
