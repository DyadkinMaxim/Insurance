package com.insurance.calculator.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeClassDTO {

    private long id = -1;
    private String className;
    private Double value;
}