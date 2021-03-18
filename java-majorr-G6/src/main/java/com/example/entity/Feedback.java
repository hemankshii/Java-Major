package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * @author vedangt
 *
 */
@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	private String feedback;
	private int ratings;
	
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

	public Feedback(int feedbackId, String feedback, Course course, User user) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.course = course;
		this.user = user;
	}

	public Feedback(String feedback, Course course, User user) {
		super();
		this.feedback = feedback;
		this.course = course;
		this.user = user;
	}

	public Feedback() {
		super();
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
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
