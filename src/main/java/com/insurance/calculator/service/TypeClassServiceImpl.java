package com.insurance.calculator.service;

import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.rest.NotFoundException;
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
    public TypeClass save(@NonNull TypeClass newTypeClass) {
        typeClassRepository.save(newTypeClass);
        return newTypeClass;
    }

    @Transactional
    public void update(@NonNull TypeClass typeClass) {
        TypeClass savedTypeClass = typeClassRepository.findById(typeClass.getId()).orElseThrow(NotFoundException::new);
        savedTypeClass.setClassName(typeClass.getClassName());
        savedTypeClass.setFactorValue(typeClass.getFactorValue());
    }
}
