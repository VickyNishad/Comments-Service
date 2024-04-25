package com.comments.contoller;

import org.springframework.http.ResponseEntity;

import com.comments.model.request.CommentsRequest;
import com.comments.model.response.CommentsResponse;

public interface ProcessController {
	
	public ResponseEntity<CommentsResponse> submitDetails(CommentsRequest commentsRequest);

	public ResponseEntity<CommentsResponse> updateDetails(CommentsRequest commentsRequest);

	public ResponseEntity<CommentsResponse> deleteDetails(long id);

	public ResponseEntity<CommentsResponse> searchDetails(String username, String date);
	
}
