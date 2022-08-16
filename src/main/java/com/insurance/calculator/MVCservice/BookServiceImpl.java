package com.insurance.calculator.MVCservice;

import com.insurance.calculator.models.Author;
import com.insurance.calculator.models.Book;
import com.insurance.calculator.models.Comment;
import com.insurance.calculator.models.Style;
import com.insurance.calculator.repositoriesSpringDataJPA.AuthorRepository;
import com.insurance.calculator.repositoriesSpringDataJPA.BookRepository;
import com.insurance.calculator.repositoriesSpringDataJPA.CommentRepository;
import com.insurance.calculator.repositoriesSpringDataJPA.StyleRepository;
import com.insurance.calculator.rest.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BookServiceImpl implements  BookService{

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;
    private final AuthorRepository authorRepository;
    private final StyleRepository styleRepository;
    private Author existingAuthor;
    private Style existingStyle;

    public BookServiceImpl(BookRepository bookRepository,
                           CommentRepository commentRepository,
                           AuthorRepository authorRepository,
                           StyleRepository styeRepository){
        this.bookRepository = bookRepository;
        this.commentRepository = commentRepository;
        this.authorRepository = authorRepository;
        this.styleRepository = styeRepository;
    }


    @Transactional
    public Book save(Book book, List<Comment> comments){
        for(Comment comment : comments) {
            comment.setBook(book);
        }
        existingAuthor = authorRepository.findByAuthorNameContains(book.getAuthor().getAuthorName());
        existingStyle = styleRepository.findByStyleNameContains(book.getStyle().getStyleName());
        book.setAuthor(existingAuthor);
        book.setStyle(existingStyle);
        book.setComment(comments);
        Book newBook = bookRepository.save(book);
        return newBook;
    }

    @Transactional
    public void update(Book book) {
        Book savedBook = bookRepository.findById(book.getId()).orElseThrow(NotFoundException::new);
        savedBook.setBookName(book.getBookName());
        existingAuthor = authorRepository.findByAuthorNameContains(book.getAuthor().getAuthorName());
        existingStyle = styleRepository.findByStyleNameContains(book.getStyle().getStyleName());
        savedBook.setAuthor(existingAuthor);
        savedBook.setStyle(existingStyle);
    }
}
