package com.in28minutes.jpa.hibernate.demo.repository;



import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@SpringBootTest(classes = DemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository repository;

	@Test
	public void findById() {
		Optional<Course> course=repository.findById(10001L);
		logger.info("Course Present : {}",course.isPresent());
		assertTrue(course.isPresent());
	}
	
	@Test
	public void findById_CourseNotPresent() {
		Optional<Course> course=repository.findById(2000L);
		logger.info("Course not Present : {}",course.isPresent());
		assertFalse(course.isPresent());
	}
	
	@Test
	public void sort() {
		Sort sort=Sort.by(Sort.Direction.ASC,"name");
		logger.info("Sorted Courses : {}",repository.findAll(sort));
	}
	
	@Test
	public void pagination() {
		PageRequest pageRequest=PageRequest.of(0, 2);
		Page<Course> firstPage=repository.findAll(pageRequest);
		logger.info("First Page : {}",firstPage.getContent());
		
		Pageable secondPageable=firstPage.nextPageable();
		Page<Course> secondPage=repository.findAll(secondPageable);
		logger.info("Second Page : {}",secondPage.getContent());
	}

}
