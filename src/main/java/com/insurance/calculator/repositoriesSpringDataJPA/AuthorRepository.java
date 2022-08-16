package com.insurance.calculator.repositoriesSpringDataJPA;

import com.insurance.calculator.models.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface AuthorRepository extends CrudRepository<Author, Long> {

    List<Author> findAll();

    Author findByAuthorNameContains(String name);
}
