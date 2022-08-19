package com.insurance.calculator.dao;

import com.insurance.calculator.domain.TypeClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeClassRepository extends JpaRepository<TypeClass, Long> {

    List<TypeClass> findAll();

    TypeClass findByClassName(String name);
}
