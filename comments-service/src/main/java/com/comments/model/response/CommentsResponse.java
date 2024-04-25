/**
 * 
 */
package com.comments.model.response;

/**
 * 
 */
public class CommentsResponse {

	private String statusCode;
	private String message;
	private Object result;

	public CommentsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public CommentsResponse(String statusCode, String message, Object result) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.result = result;
	}

}
