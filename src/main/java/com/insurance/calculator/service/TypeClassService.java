package com.insurance.calculator.service;

import com.insurance.calculator.domain.TypeClass;

public interface TypeClassService {
    TypeClass save(TypeClass typeClass);

    void update(TypeClass typeClass);
}
