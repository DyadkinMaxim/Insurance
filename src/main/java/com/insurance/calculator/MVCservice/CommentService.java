package com.insurance.calculator.MVCservice;

import com.insurance.calculator.models.Comment;

public interface CommentService {

    void saveComment(Comment comment, long bookId);
}
