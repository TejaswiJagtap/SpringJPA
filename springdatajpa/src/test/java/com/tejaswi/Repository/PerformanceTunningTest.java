package com.tejaswi.Repository;

import java.util.List;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tejaswi.SpringdatajpaApplication;
import com.tejaswi.Entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringdatajpaApplication.class)
public class PerformanceTunningTest 
{
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Transactional
	public void solving_NPlusOne_Problem()
	{
		//create entity graph
		EntityGraph<Course> entitygraph=em.createEntityGraph(Course.class);
		//create a sub graph
		Subgraph<Object> subgraph=entitygraph.addSubgraph("student");
		
		TypedQuery<Course> query=em.createNamedQuery("find_all_courses", Course.class)
				.setHint("javax.persistence.loadgraph", entitygraph);
		List<Course> courses=query.getResultList();
		for(Course course: courses)
		{
			logger.info("course->{} ",course);
			logger.info("student->{}",course.getStudent());
		}
		
	}
	/*
	@Test
	public void solving_NPlusOne_Problem_join_fetch()
	{
		List<Course> courses=em.createNamedQuery("find_all_courses_join_fetch", Course.class)
		 .getResultList();
		for(Course course: courses)
		{
			logger.info("course->{} ",course);
			logger.info("student->{}",course.getStudent());
		}
		
	}
		*/
}
