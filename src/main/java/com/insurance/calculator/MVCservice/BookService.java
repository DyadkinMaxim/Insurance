package com.insurance.calculator.MVCservice;

import com.insurance.calculator.models.Book;
import com.insurance.calculator.models.Comment;

import java.util.List;

public interface BookService {

    Book save(Book book, List<Comment> comments);

    void update(Book book);
}
