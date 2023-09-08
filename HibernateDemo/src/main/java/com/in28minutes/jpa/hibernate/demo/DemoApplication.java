package com.in28minutes.jpa.hibernate.demo;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.EmployeeRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	@Autowired
	private StudentRepository studentRepository;


	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
//		repository.playWithEntityManager();
//		studentRepository.saveStudentWithPassport();
//		studentRepository.playWithEntityManager();
//		
		
//		List<Review> reviewList= new ArrayList<>();
//		reviewList.add(new Review("5","Flabbergasting"));
//		reviewList.add(new Review("4","Great Course"));
//		repository.addReviewstoCourse(10003L, reviewList);
		
		
//		studentRepository.insertHardcodedStudentAndCourse();
//		studentRepository.insertStudentAndCourse(new Student("kakashi"), new Course("Spring Cloud Microservices"));
		
		employeeRepository.insert(new FullTimeEmployee("Gara", new BigDecimal("10000")));
		employeeRepository.insert(new PartTimeEmployee("Sai", new BigDecimal("50")));
		
		logger.info("All Employees -> {}",employeeRepository.retrieveAllEmployees());
		
	}	
}
