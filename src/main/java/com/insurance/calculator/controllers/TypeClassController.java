package com.insurance.calculator.controllers;

import com.insurance.calculator.domain.TypeClass;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TypeClassController {

    List<TypeClass> getAllTypeClasses();

    void deleteTypeClass(long id);

    TypeClass updateTypeClass( @RequestBody TypeClass typeClass);

    TypeClass saveTypeClass(@RequestBody TypeClass typeClass);
}
