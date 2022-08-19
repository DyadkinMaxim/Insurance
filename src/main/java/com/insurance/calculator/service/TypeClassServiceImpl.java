package com.insurance.calculator.service;

import com.insurance.calculator.controllers.NotFoundException;
import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.dao.TypeClassRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TypeClassServiceImpl implements TypeClassService {

    private final TypeClassRepository typeClassRepository;

    public TypeClassServiceImpl(TypeClassRepository typeClassRepository){
        this.typeClassRepository = typeClassRepository;
    }

    @Transactional
    public TypeClass update(@NonNull TypeClass typeClass) {
        TypeClass savedTypeClass = typeClassRepository.findById(typeClass.getId()).orElseThrow(NotFoundException::new);
        savedTypeClass.setClassName(typeClass.getClassName());
        savedTypeClass.setFactorValue(typeClass.getFactorValue());
        TypeClass newTypeClass = typeClassRepository.save(savedTypeClass);
        return newTypeClass;
    }
}
