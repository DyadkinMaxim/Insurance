package com.insurance.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegionDTO {

    private long id;

    private String federalState;

    private String county;

    private String city;

    private long postCode;

    private String location;

    private double factorValue;
}
