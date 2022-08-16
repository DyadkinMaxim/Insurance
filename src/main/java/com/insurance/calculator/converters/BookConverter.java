package com.insurance.calculator.converters;

import com.insurance.calculator.dto.BookDTO;
import com.insurance.calculator.models.Book;

public interface BookConverter {

    BookDTO toDTO(Book book);

    Book toBook(BookDTO bookDTO);
}
