/**
 * 
 */
package com.comments.service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.comments.exception.CustomeException;
import com.comments.model.Comment;
import com.comments.model.request.CommentsRequest;
import com.comments.model.response.CommentsResponse;
import com.comments.repository.CommentsRepository;
import com.comments.utility.CommentsUtility;
import com.comments.utility.ValidatorUtility;


/**
 * 
 */
@Service
public class CommentsService implements CommentsProcess{
	
	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public ResponseEntity<CommentsResponse> submitDetails( CommentsRequest commentsRequest) {
		// TODO Auto-generated method stub
		try {
			//  validate the request
			ValidatorUtility validatorUtility = new ValidatorUtility();
			validatorUtility.validateRequest(commentsRequest);
			
			
			Comment comments = new Comment();
			comments.setCommentby(commentsRequest.getCommentby());
			comments.setText(commentsRequest.getText());
			comments.setDateOfComment(String.valueOf(LocalDateTime.now()));
			commentsRepository.save(comments);
			
			CommentsResponse response = new CommentsResponse();
			response.setStatusCode(CommentsUtility.STATUS_CODE);
			response.setMessage(CommentsUtility.RECORD_INSERTED);
			response.setResult(comments);
			return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			
		} catch (CustomeException e) {
			// TODO: handle exception
			throw new CustomeException(e.getMessage(), e.getHttpStatus());
		}
		catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(CommentsUtility.RUNTIME_ERROR);
		}
	}

	@Override
	public ResponseEntity<CommentsResponse> updateDetails(CommentsRequest commentsRequest) {
		// TODO Auto-generated method stub
		try {
			
			ValidatorUtility validatorUtility = new ValidatorUtility();
			validatorUtility.validateRequest(commentsRequest, commentsRequest.getId());
			
			
			
			Comment comment = commentsRepository.findById(commentsRequest.getId()).orElse(null);
			if(comment==null) {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.STATUS_CODE);
				response.setMessage(CommentsUtility.RECORD_NOT_UPDATED);
				response.setResult(comment);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}else {
				Comment comments = new Comment();
				comments.setId(comment.getId());
				comments.setCommentby(commentsRequest.getCommentby());
				comments.setText(commentsRequest.getText());
				comments.setDateOfComment(String.valueOf(LocalDateTime.now()));
				commentsRepository.save(comments);
				
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.STATUS_CODE);
				response.setMessage(CommentsUtility.RECORD_UPDATED);
				response.setResult(comments);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(CommentsUtility.RUNTIME_ERROR);
		}
	}

	@Override
	public ResponseEntity<CommentsResponse> deleteDetails(long id) {
		// TODO Auto-generated method stub
		try {
			
			ValidatorUtility validatorUtility = new ValidatorUtility();
			validatorUtility.validateRequest(id);
			
			Comment comment = commentsRepository.findById(id).orElse(null);
			if(comment==null) {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.ERROR_CODE);
				response.setMessage(CommentsUtility.RECORD_NOT_DELETED);
				response.setResult(comment);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}else {
				commentsRepository.deleteById(id);
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.STATUS_CODE);
				response.setMessage(CommentsUtility.RECORD_DELETED);
				response.setResult(comment);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
				
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(CommentsUtility.RUNTIME_ERROR);
		}
	}


	@Override
	public ResponseEntity<CommentsResponse> getCommentsByUsername(String username) {
		// TODO Auto-generated method stub
		try {
			Collection<Comment> list = commentsRepository.getCommentsByUsername(username);
			if(list==null || list.isEmpty() || list.size()==0) {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.ERROR_CODE);
				response.setMessage(CommentsUtility.RECORD_NOT_FOUND);
				response.setResult(list);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}else {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.STATUS_CODE);
				response.setMessage(CommentsUtility.RECORD_FOUND);
				response.setResult(list);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(CommentsUtility.RUNTIME_ERROR);
			
		}
	}

	
	public ResponseEntity<CommentsResponse> getCommentsByDate(String date) {
		// TODO Auto-generated method stub
		try {
			Collection<Comment> list = commentsRepository.getCommentsByDate(date);
			if(list==null || list.isEmpty() || list.size()==0) {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.ERROR_CODE);
				response.setMessage(CommentsUtility.RECORD_NOT_FOUND);
				response.setResult(list);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}else {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.STATUS_CODE);
				response.setMessage(CommentsUtility.RECORD_FOUND);
				response.setResult(list);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(CommentsUtility.RUNTIME_ERROR);
			
		}

	}

	
	public ResponseEntity<CommentsResponse> getAllComments() {
		// TODO Auto-generated method stub
		try {
			List<Comment> list = (List<Comment>) commentsRepository.findAll();
			if(list==null || list.isEmpty() || list.size()==0) {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.ERROR_CODE);
				response.setMessage(CommentsUtility.RECORD_NOT_FOUND);
				response.setResult(list);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}else {
				CommentsResponse response = new CommentsResponse();
				response.setStatusCode(CommentsUtility.STATUS_CODE);
				response.setMessage(CommentsUtility.RECORD_FOUND);
				response.setResult(list);
				return new ResponseEntity<CommentsResponse>(response,HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(CommentsUtility.RUNTIME_ERROR);
			
		}
	}

}
