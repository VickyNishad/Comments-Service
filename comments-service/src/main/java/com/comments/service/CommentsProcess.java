package com.comments.service;

import org.springframework.http.ResponseEntity;

import com.comments.model.request.CommentsRequest;
import com.comments.model.response.CommentsResponse;

public interface CommentsProcess {

	public ResponseEntity<CommentsResponse> submitDetails(CommentsRequest commentsRequest);

	public ResponseEntity<CommentsResponse> updateDetails(CommentsRequest commentsRequest);

	public ResponseEntity<CommentsResponse> deleteDetails(long id);

	public ResponseEntity<CommentsResponse> getCommentsByUsername(String username);

	public ResponseEntity<CommentsResponse> getCommentsByDate(String date);
	
	public ResponseEntity<CommentsResponse> getAllComments();

}
