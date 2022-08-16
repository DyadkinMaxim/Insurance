package com.insurance.calculator.repositoriesSpringDataJPA;

import com.insurance.calculator.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}
