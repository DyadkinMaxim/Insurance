package com.insurance.calculator.repositoriesSpringDataJPA;

import com.insurance.calculator.models.Style;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StyleRepository extends CrudRepository<Style, Long> {

    List<Style> findAll();

    Style findByStyleNameContains(String name);
}
