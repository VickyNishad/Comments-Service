/**
 * 
 */
package com.comments.exception;

/**
 * 
 */
public class ApiError {

	/**
	 * 
	 */
	public ApiError() {
		// TODO Auto-generated constructor stub
	}
	
	private String statusCode;
	private String message;
	private Object result;

	public ApiError(String statusCode, String message, Object result) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.result = result;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ApiError [statusCode=" + statusCode + ", message=" + message + ", result=" + result + "]";
	}
	
	

}
