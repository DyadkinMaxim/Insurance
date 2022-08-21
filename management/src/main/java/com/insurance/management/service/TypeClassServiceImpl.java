package com.insurance.management.service;

import com.insurance.management.controllers.NotFoundException;
import com.insurance.management.domain.TypeClass;
import com.insurance.management.dto.TypeClassDTO;
import com.insurance.management.repository.TypeClassRepository;
import org.modelmapper.ModelMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeClassServiceImpl implements TypeClassService {

    private final TypeClassRepository typeClassRepository;

    private final ModelMapper modelMapper;

    public TypeClassServiceImpl(TypeClassRepository typeClassRepository,
                                ModelMapper modelMapper){
        this.typeClassRepository = typeClassRepository;
        this.modelMapper =  modelMapper;
    }

    @Transactional
    public TypeClassDTO save(@NonNull TypeClassDTO newTypeClassDTO) {
        var newTypeClass = typeClassRepository.save(modelMapper.map(newTypeClassDTO, TypeClass.class));
        return modelMapper.map(newTypeClass, TypeClassDTO.class);
    }

    public List<TypeClassDTO> findAll(){
        return typeClassRepository.findAll().stream().map(
                typeClass -> modelMapper.map(typeClass, TypeClassDTO.class))
                .collect(Collectors.toList());
    }

    public TypeClassDTO findByClassName(String name) throws NotFoundException {
        return modelMapper.map(typeClassRepository.findByClassNameContains(name).orElseThrow(NotFoundException::new), TypeClassDTO.class);
    }

    @Transactional
    public TypeClassDTO update(@NonNull TypeClassDTO typeClassDTO) {
        var savedTypeClass = typeClassRepository.findById(typeClassDTO.getId()).orElseThrow(NotFoundException::new);
        savedTypeClass.setClassName(typeClassDTO.getClassName());
        savedTypeClass.setFactorValue(typeClassDTO.getFactorValue());
        return modelMapper.map(savedTypeClass, TypeClassDTO.class);
    }

    public void deleteById(long typeClassId){
        typeClassRepository.deleteById(typeClassId);
    }
}
