package com.insurance.calculator.rest;

import com.insurance.calculator.repositoriesSpringDataJPA.AuthorRepository;
import com.insurance.calculator.converters.AuthorConverterImpl;
import com.insurance.calculator.dto.AuthorDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorConverterImpl authorConverterImpl;

    public AuthorController(AuthorRepository authorRepository, AuthorConverterImpl authorConverterImpl) {
        this.authorRepository = authorRepository;
        this.authorConverterImpl = authorConverterImpl;
    }

    @GetMapping("/api/authors")
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream().map(authorConverterImpl::toDTO)
                .collect(Collectors.toList());
    }
}
