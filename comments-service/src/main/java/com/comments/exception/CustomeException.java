package com.comments.exception;

import org.springframework.http.HttpStatus;

public class CustomeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public CustomeException() {
		// TODO Auto-generated constructor stub
	}

	private String message;
	private HttpStatus httpStatus;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CustomeException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public CustomeException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomeException [message=" + message + ", httpStatus=" + httpStatus + "]";
	}
	
	

}
