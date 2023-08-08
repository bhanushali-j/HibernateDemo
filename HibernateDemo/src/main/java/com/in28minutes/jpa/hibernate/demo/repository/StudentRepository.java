package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {

		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}

		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}

	public void playWithEntityManager(){
		try {
			Student student = new Student("Vegeta");
			em.persist(student);
			em.flush();
			student.setName("Prince Vegeta !!!");
			throw new Exception("Some exception for rollback the above changes");
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void saveStudentWithPassport() {
		
		Passport passport=new Passport("X123456");
		em.persist(passport);
		
		Student student=new Student("Itachi");
		student.setPassport(passport);
		em.persist(student);
	}
	
	public void understandTransactionManagement() {
		
		Student student=em.find(Student.class,20003L);
		
		Passport passport=student.getPassport();
		
		logger.info("student -> {}",student);
		logger.info("Passport -> {}",student.getPassport());
		
		passport.setName("F12345");
		
		student.setName("Goku Updated !");
		
		logger.info("student -> {}",student);
		logger.info("Passport -> {}",student.getPassport());
	}
	
	
}
