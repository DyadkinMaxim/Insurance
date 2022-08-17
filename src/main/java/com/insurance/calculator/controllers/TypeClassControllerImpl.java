package com.insurance.calculator.controllers;

import com.insurance.calculator.dao.TypeClassRepository;
import com.insurance.calculator.domain.TypeClass;
import com.insurance.calculator.rest.NotFoundException;
import com.insurance.calculator.service.TypeClassService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TypeClassControllerImpl implements TypeClassController {

    private final TypeClassRepository typeClassRepository;
    private final TypeClassService typeClassService;

    public TypeClassControllerImpl(TypeClassRepository typeClassRepository,
                                   TypeClassService typeClassService) {
        this.typeClassRepository = typeClassRepository;
        this.typeClassService = typeClassService;
    }

    @GetMapping("/management/typeClasses")
    public List<TypeClass> getAllTypeClasses() {
        return new ArrayList<>(typeClassRepository.findAll());
    }

    @DeleteMapping("management/typeClass/{id}")
    public void deleteTypeClass(@PathVariable(value = "id") long id) {
        typeClassRepository.deleteById(id);
    }

    @PutMapping("/management/typeClass/{id}")
    @ExceptionHandler(NotFoundException.class)
    public void updateTypeClass(
            @RequestBody TypeClass typeClass
    ) {
        typeClassService.update(typeClass);
    }


    @PostMapping("/management/typeClass/newTypeClass")
    public void saveTypeClass(
            @RequestBody TypeClass newTypeClass
    ) {
        typeClassService.save(newTypeClass);
    }
}
