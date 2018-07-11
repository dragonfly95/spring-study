package com.example.repository;

import com.example.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by minah on 2016-10-02.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
