package com.insurance.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PremiumDTO {

    private long id;

    private double premiumValue;

    private double mileageFactor;

    private long typeClassFactorId;

    private long regionalFactorId;
}
