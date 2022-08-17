package com.insurance.calculator.converters;

import com.insurance.calculator.models.Book;
import com.insurance.calculator.dto.BookDTO;
import com.insurance.calculator.models.Author;
import com.insurance.calculator.models.Comment;
import com.insurance.calculator.models.Style;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookConverterImpl implements BookConverter {

    public BookDTO toDTO(Book book) {
        List<String> comments = new ArrayList<>();
        for (Comment comment : book.getComment()) {
            comments.add(comment.getCommentText());
        }
        return new BookDTO(book.getId(),
                book.getBookName(),
                book.getAuthor().getAuthorName(),
                book.getStyle().getStyleName(),
                comments);
    }

    public Book toBook(BookDTO bookDTO) {

        Author author = new Author();
        author.setAuthorName(bookDTO.getAuthorName());
        Style style = new Style();
        style.setStyleName(bookDTO.getStyleName());
        List<Comment> comments = new ArrayList<>();
        if(Objects.nonNull(bookDTO.getComments())) {
            for (String commentText : bookDTO.getComments()) {
                Comment comment = new Comment();
                comment.setCommentText(commentText);
                comments.add(comment);
            }
        }
        return new Book(bookDTO.getId(),
                bookDTO.getBookName(),
                author,
                style,
                comments);
    }
}
