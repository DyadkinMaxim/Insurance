package com.insurance.management.service;


import com.insurance.management.dto.TypeClassDTO;

import java.util.List;

public interface TypeClassService {
    TypeClassDTO save(TypeClassDTO typeClassDTO);

    List<TypeClassDTO> findAll();

    TypeClassDTO findByClassName(String name);

    TypeClassDTO update(TypeClassDTO typeClass);

    void deleteById(long typeClassId);
}
