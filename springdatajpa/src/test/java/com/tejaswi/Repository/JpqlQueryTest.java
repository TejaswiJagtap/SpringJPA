package com.tejaswi.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tejaswi.SpringdatajpaApplication;
import com.tejaswi.Entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringdatajpaApplication.class)
public class JpqlQueryTest 
{
	@Autowired
	EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void findAll()
	{
		TypedQuery<Course> query=em.createQuery("Select c From Course c", Course.class);
		List<Course> resultList=query.getResultList();
		logger.info("All list of Courses->{}",resultList);
	}
	
	@Test
	public void likepattern()
	{
		TypedQuery<Course> query=em.createNamedQuery("find_like_pattern", Course.class);
		List<Course> resultList=query.getResultList();
		logger.info("find all using like pattern->{}",resultList);
	}
}
