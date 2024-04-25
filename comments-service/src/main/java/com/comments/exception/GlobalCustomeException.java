/**
 * 
 */
package com.comments.exception;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author
 *
 */
@ControllerAdvice
public class GlobalCustomeException {

	/**
	 * 
	 */
	public GlobalCustomeException() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(CustomeException.class)
	protected ResponseEntity<?> requestNotfoundException(CustomeException customeException) {
		// TODO Auto-generated method stub
//		ApiError apiError = new ApiError(String.valueOf(customeException.getHttpStatus()), customeException.getMessage(), new Object());
		HashMap<String, Object> stringObjectMap = new HashMap<String, Object>();
		stringObjectMap.put("statusCode", "0");
		stringObjectMap.put("httpStatus", customeException.getHttpStatus());
		stringObjectMap.put("message", customeException.getMessage());
		stringObjectMap.put("result", new HashMap<String, Object>());

		return new ResponseEntity<Object>(stringObjectMap, customeException.getHttpStatus());
	}

	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<?> runtimeException(RuntimeException runtimeException) {
		// TODO Auto-generated method stub
//		ApiError apiError = new ApiError(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR),
//				runtimeException.getMessage(), new Object());
		HashMap<String, Object> stringObjectMap = new HashMap<String, Object>();
		stringObjectMap.put("statusCode", "0");
		stringObjectMap.put("httpStatus", HttpStatus.INTERNAL_SERVER_ERROR);
		stringObjectMap.put("message", runtimeException.getMessage());
		stringObjectMap.put("result", new HashMap<String, Object>());

		return new ResponseEntity<Object>(stringObjectMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
