package com.in28minutes.jpa.hibernate.demo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

	@Id
	@GeneratedValue
	private Long id;

	private String rating;
	
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Course course;
	

	
	public Review(String rating, String description) {
		super();
		this.rating = rating;
		this.description = description;
	}


	protected Review() {
	}

	
	public String getRating() {
		return rating;
	}


	public void setRating(String rating) {
		this.rating = rating;
	}


	public Review(String name) {
		this.description = name;
	}

	public String getName() {
		return description;
	}

	public void setName(String name) {
		this.description = name;
	}

	public Long getId() {
		return id;
	}
	

	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return String.format("Review[%s]",rating , description);
	}
}