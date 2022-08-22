package com.insurance.managementTest.controllers;

import com.insurance.managementTest.dto.TypeClassDTO;
import com.insurance.managementTest.service.TypeClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TypeClassControllerImpl implements TypeClassController {

    private final TypeClassService typeClassService;

    public TypeClassControllerImpl(TypeClassService typeClassService) {
        this.typeClassService = typeClassService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/management/typeClasses")
    public List<TypeClassDTO> findAllTypeClasses() {
        return typeClassService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/management/typeClasses/{name}")
    public TypeClassDTO findByClassName(@PathVariable(value = "name") String name) {
        return typeClassService.findByClassName(name);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/management/typeClass/newTypeClass")
    public TypeClassDTO saveTypeClass(
            @RequestBody TypeClassDTO newTypeClassDTO
    ) {
        log.debug("Saving new typeClass with name {}", newTypeClassDTO.getClassName());
        return typeClassService.save(newTypeClassDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/management/typeClass/{id}")
    public TypeClassDTO updateTypeClass(
            @RequestBody TypeClassDTO typeClassDTO
    ) {
        log.debug("Updating typeClass with name {}", typeClassDTO.getClassName());
        return typeClassService.update(typeClassDTO);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("management/typeClass/{id}")
    public void deleteTypeClass(@PathVariable(value = "id") long id) {
        log.debug("Deleting typeClass with id {}", id);
        typeClassService.deleteById(id);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Throwable ex) {
        // For any exceptions
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Throwable ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
