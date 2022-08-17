package com.insurance.calculator.mappers;

import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.transfer.TypeClassDTO;

public interface TypeClassMapper {
    TypeClassDTO toDTO(TypeClass typeClass);

    TypeClass toTypeClass(TypeClassDTO typeClassDTO);
}
