package com.insurance.calculator.mappers;

import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.transfer.TypeClassDTO;
import org.springframework.stereotype.Service;

@Service
public class TypeClassMapperImpl implements TypeClassMapper {

    public TypeClassDTO toDTO(TypeClass typeClass) {
        return new TypeClassDTO(typeClass.getId(),
                typeClass.getClassName(),
                typeClass.getFactorValue());
    }

    public TypeClass toTypeClass(TypeClassDTO typeClassDTO) {
        return new TypeClass(typeClassDTO.getId(),
                typeClassDTO.getClassName(),
                typeClassDTO.getValue());
    }
}
