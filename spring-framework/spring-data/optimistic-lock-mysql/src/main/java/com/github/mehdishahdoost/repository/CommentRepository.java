package com.github.mehdishahdoost.repository;

import com.github.mehdishahdoost.model.Comment;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
