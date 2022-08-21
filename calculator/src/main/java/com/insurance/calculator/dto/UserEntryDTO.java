package com.insurance.calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntryDTO {

    private long mileage;

    private String typeClassName;

    private long postcode;
}