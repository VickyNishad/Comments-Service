/**
 * 
 */
package com.comments.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 */
@Entity
@Table(name = "Comments_Master")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CommentBy", nullable = false)
	private String commentby;

	@Column(name = "Text", nullable = false)
	private String text;

	private String dateOfComment;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getDateOfComment() {
		return dateOfComment;
	}

	public void setDateOfComment(String dateOfComment) {
		this.dateOfComment = dateOfComment;
	}

	public Comment(Long id, String commentby, String text, String dateOfComment) {
		super();
		this.id = id;
		this.commentby = commentby;
		this.text = text;
		this.dateOfComment = dateOfComment;
	}

}
