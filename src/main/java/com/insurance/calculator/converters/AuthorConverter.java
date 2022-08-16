package com.insurance.calculator.converters;

import com.insurance.calculator.dto.AuthorDTO;
import com.insurance.calculator.models.Author;

public interface AuthorConverter {
    AuthorDTO toDTO(Author author);
}
