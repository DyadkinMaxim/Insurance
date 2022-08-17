package com.insurance.calculator.rest;

import com.insurance.calculator.MVCservice.CommentService;
import com.insurance.calculator.dto.CommentDTO;
import com.insurance.calculator.models.Book;
import com.insurance.calculator.repositoriesSpringDataJPA.BookRepository;
import com.insurance.calculator.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;
    private final BookRepository bookRepository;

    @Autowired
    public CommentController(CommentService commentService, BookRepository bookRepository) {
        this.commentService = commentService;
        this.bookRepository = bookRepository;
    }

    @PostMapping("/api/comments/newComment")
    @ExceptionHandler(NotFoundException.class)
    public void saveComment(
            @RequestBody CommentDTO commentDTO
    ) {
        Book commentBook = bookRepository.findById(commentDTO.getBookId()).orElse(new Book());
        Comment comment = new Comment();
        comment.setCommentText(commentDTO.getCommentText());
        comment.setBook(commentBook);
        commentService.saveComment(comment, commentDTO.getBookId());
    }
}
