package com.insurance.calculator.converters;

import com.insurance.calculator.dto.AuthorDTO;
import com.insurance.calculator.models.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorConverterImpl implements AuthorConverter{

    public AuthorDTO toDTO(Author author) {
        return new AuthorDTO(
                author.getId(),
                author.getAuthorName()
        );
    }
}
