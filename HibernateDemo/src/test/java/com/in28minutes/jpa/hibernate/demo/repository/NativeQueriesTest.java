package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@SpringBootTest(classes = DemoApplication.class)
public class NativeQueriesTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void native_queries_basic() {
		Query query = em.createNativeQuery("select * from course",Course.class);
		List resultList = query.getResultList();
		logger.info("select * from course -> {}",resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = 
					em.createNamedQuery("query_get_all_courses",Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Select  c  From Course c -> {}",resultList);
	}

	@Test
	public void native_queries_where() {
		Query query = 
					em.createNativeQuery("Select  *  From Course where id=?", Course.class);
		query.setParameter(1, 10001L);
		List<Course> resultList = query.getResultList();
		
		logger.info("Select  c  From Course c where name like '%100 Steps'-> {}",resultList);
		//[Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
	}

}
