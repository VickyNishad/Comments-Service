/**
 * 
 */
package com.comments.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comments.model.request.CommentsRequest;
import com.comments.model.response.CommentsResponse;
import com.comments.service.CommentsService;
import com.comments.utility.CommentsUtility;

/**
 * 
 */
@RestController
@RequestMapping("/api/v2/comments")
public class CommentsController implements ProcessController {

	@Autowired
	private CommentsService commentsService;

	@PostMapping("/submitDetails")
	@Override
	public ResponseEntity<CommentsResponse> submitDetails(@RequestBody CommentsRequest commentsRequest) {
		// TODO Auto-generated method stub
		return commentsService.submitDetails(commentsRequest);
	}

	@PutMapping("/updateDetails")
	@Override
	public ResponseEntity<CommentsResponse> updateDetails(@RequestBody CommentsRequest commentsRequest) {
		// TODO Auto-generated method stub
		return commentsService.updateDetails(commentsRequest);
	}

	@DeleteMapping("/deleteDetails")
	@Override
	public ResponseEntity<CommentsResponse> deleteDetails(@RequestParam long id) {
		// TODO Auto-generated method stub
		return commentsService.deleteDetails(id);
	}
	/**
	 * this method for search coments
	 */
	@GetMapping()
	@Override
	public ResponseEntity<CommentsResponse> searchDetails(
			@RequestParam(value = "username", required = false) String username,
			@RequestParam(value = "date", required = false) String date) {
		// TODO Auto-generated method stub
		try {
			if (username != null && !username.isEmpty()) {
				return commentsService.getCommentsByUsername(username);
			} else if (date != null && !date.isEmpty()) {
				return commentsService.getCommentsByDate(date);
			} else {
				return commentsService.getAllComments();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(CommentsUtility.RUNTIME_ERROR);
		}
	}

}
