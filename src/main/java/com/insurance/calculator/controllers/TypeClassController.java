package com.insurance.calculator.controllers;

import com.insurance.calculator.domain.TypeClass;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TypeClassController {

    List<TypeClass> getAllTypeClasses();

    void deleteTypeClass(long id);

    void updateTypeClass( @RequestBody TypeClass typeClass);

    void saveTypeClass(@RequestBody TypeClass typeClass);
}
