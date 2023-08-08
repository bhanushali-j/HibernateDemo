package com.in28minutes.jpa.hibernate.demo.repository;



import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void retrievePassportFromStudent() {
		Student student=em.find(Student.class,20003L);
		logger.info("student -> {}",student);
		logger.info("Passport -> {}",student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrieveStudentFromPassport() {
		Passport passport=em.find(Passport.class,40003L);
		logger.info("passport -> {}",passport);
		logger.info("Passport -> {}",passport.getStudent());
	}
	
	@Test
	public void understandTransactionManagementTest() {
		repository.understandTransactionManagement();
	}
	
	@Test
	@Transactional
	public void retrieveCourseFromStudent() {
		
		Student student=em.find(Student.class,20001L);
		logger.info("student -> {}",student);
		
		logger.info("Passport -> {}",student.getCourseList());
	}

}
