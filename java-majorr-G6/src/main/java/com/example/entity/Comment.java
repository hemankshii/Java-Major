package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Comment{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	private String comment;
	
//	@ManyToOne
//	@JoinColumns({@JoinColumn(name="courseId", referencedColumnName = "courseId"),@JoinColumn(name="userId", referencedColumnName = "userId")})
//	private Course course;
//	private User user;
	
	@ManyToOne(targetEntity = Course.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="courseId", referencedColumnName = "courseId")
	private Course course;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private User user;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
