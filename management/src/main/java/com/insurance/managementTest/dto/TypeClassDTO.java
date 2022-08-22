package com.insurance.managementTest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TypeClassDTO {

    private long id;

    private String className;

    private double factorValue;
}
