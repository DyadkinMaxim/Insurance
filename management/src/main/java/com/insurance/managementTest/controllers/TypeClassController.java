package com.insurance.managementTest.controllers;

import com.insurance.managementTest.dto.TypeClassDTO;

import java.util.List;

public interface TypeClassController {

    List<TypeClassDTO> findAllTypeClasses();

    TypeClassDTO findByClassName(String name);

    void deleteTypeClass(long id);

    TypeClassDTO updateTypeClass(TypeClassDTO typeClass);

    TypeClassDTO saveTypeClass(TypeClassDTO typeClass);
}
