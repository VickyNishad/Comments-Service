package com.comments.utility;

import org.springframework.http.HttpStatus;

import com.comments.exception.CustomeException;
import com.comments.model.request.CommentsRequest;

public class ValidatorUtility {

	public CommentsRequest validateRequest(CommentsRequest commentsRequest) {

		if (commentsRequest == null) {
			throw new CustomeException(CommentsUtility.VALID_REQUEST, HttpStatus.BAD_REQUEST);
		} else {
			if (commentsRequest.getCommentby() == null || commentsRequest.getCommentby().isEmpty()) {
				throw new CustomeException(CommentsUtility.VALID_PARAMETER + "comment_by", HttpStatus.BAD_REQUEST);
			}
			if (commentsRequest.getText() == null || commentsRequest.getText().isEmpty()) {
				throw new CustomeException(CommentsUtility.VALID_PARAMETER + "text", HttpStatus.BAD_REQUEST);
			}

		}

		return commentsRequest;

	}

	public CommentsRequest validateRequest(CommentsRequest commentsRequest, long id) {

		if (commentsRequest == null) {
			throw new CustomeException(CommentsUtility.VALID_REQUEST, HttpStatus.BAD_REQUEST);
		} else {
			if (String.valueOf(commentsRequest.getId()).isEmpty() || String.valueOf(commentsRequest.getId()) == null) {
				throw new CustomeException(CommentsUtility.VALID_PARAMETER + "id", HttpStatus.BAD_REQUEST);
			}
			if (commentsRequest.getCommentby() == null || commentsRequest.getCommentby().isEmpty()) {
				throw new CustomeException(CommentsUtility.VALID_PARAMETER + "comment_by", HttpStatus.BAD_REQUEST);
			}
			if (commentsRequest.getText() == null || commentsRequest.getText().isEmpty()) {
				throw new CustomeException(CommentsUtility.VALID_PARAMETER + "text", HttpStatus.BAD_REQUEST);
			}

		}

		return commentsRequest;

	}

	public long validateRequest(long id) {

		if (String.valueOf(id).isEmpty() || String.valueOf(id) == null) {
			throw new CustomeException(CommentsUtility.VALID_PARAMETER + "id", HttpStatus.BAD_REQUEST);
		}

		return id;

	}

}
