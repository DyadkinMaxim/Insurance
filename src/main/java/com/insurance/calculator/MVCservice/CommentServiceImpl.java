package com.insurance.calculator.MVCservice;

import com.insurance.calculator.models.Book;
import com.insurance.calculator.models.Comment;
import com.insurance.calculator.repositoriesSpringDataJPA.BookRepository;
import com.insurance.calculator.repositoriesSpringDataJPA.CommentRepository;
import com.insurance.calculator.rest.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final BookRepository bookRepository;

    public CommentServiceImpl(CommentRepository commentRepository, BookRepository bookRepository){
        this.commentRepository = commentRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void saveComment(Comment comment, long bookId){
        Book book = bookRepository.findById(bookId).orElseThrow(NotFoundException::new);
        comment.setBook(book);
        commentRepository.save(comment);
    }
}
