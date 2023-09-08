package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name="query_get_all_courses",query="select c from Course c")
public class Course {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="course")
	private List<Review> reviewList=new ArrayList<>();
	
	@ManyToMany(mappedBy = "courseList")
	private List<Student> studentList=new ArrayList<>();

	protected Course() {
	}

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void addReview(Review review) {
		this.reviewList.add(review);
	}
	public void removeReview(Review review) {
		this.reviewList.remove(review);
	}
	
	

	public List<Student> getStudentList() {
		return studentList;
	}

	public void addStudent(Student student) {
		this.studentList.add(student);
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}