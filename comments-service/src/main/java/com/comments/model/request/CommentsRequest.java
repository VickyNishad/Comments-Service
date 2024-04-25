/**
 * 
 */
package com.comments.model.request;


/**
 * 
 */
public class CommentsRequest {
	
	private long id;
	private String commentby;
	private String text;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCommentby() {
		return commentby;
	}
	public void setCommentby(String commentby) {
		this.commentby = commentby;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public CommentsRequest(long id, String commentby, String text) {
		super();
		this.id = id;
		this.commentby = commentby;
		this.text = text;
	}

	

}
