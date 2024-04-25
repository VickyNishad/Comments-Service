package com.comments.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.comments.model.Comment;

@Repository
public interface CommentsRepository extends CrudRepository<Comment, Long>{
	@Query(value = "SELECT * FROM Comments_Master WHERE comment_by LIKE %:comment_by%", nativeQuery = true)
	Collection<Comment> getCommentsByUsername(@Param("comment_by") String comment_by);

    @Query(value = "SELECT * FROM Comments_Master WHERE date_of_comment LIKE %:date%", nativeQuery = true)
    Collection<Comment> getCommentsByDate(@Param("date") String date);
	
}
