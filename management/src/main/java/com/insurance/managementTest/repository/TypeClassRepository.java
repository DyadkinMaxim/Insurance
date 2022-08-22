package com.insurance.managementTest.repository;

import com.insurance.managementTest.domain.TypeClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TypeClassRepository extends JpaRepository<TypeClass, Long> {

    List<TypeClass> findAll();

    Optional<TypeClass> findByClassNameContains(String className);
}
