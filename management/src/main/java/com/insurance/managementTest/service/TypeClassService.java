package com.insurance.managementTest.service;


import com.insurance.managementTest.dto.TypeClassDTO;

import java.util.List;

public interface TypeClassService {
    TypeClassDTO save(TypeClassDTO typeClassDTO);

    List<TypeClassDTO> findAll();

    TypeClassDTO findByClassName(String name);

    TypeClassDTO update(TypeClassDTO typeClass);

    void deleteById(long typeClassId);
}
