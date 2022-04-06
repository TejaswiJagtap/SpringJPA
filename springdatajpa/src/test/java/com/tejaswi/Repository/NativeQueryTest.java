package com.tejaswi.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
public class NativeQueryTest 
{
	@Autowired
	EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void findAll()
	{
		Query query=em.createNativeQuery("Select * From tejaswi_courses Where is_deleted=0",Course.class);
		List resultList=query.getResultList();
		logger.info("find all list->{}",resultList);
	}
	
	/*@Test
	public void findById()
	{
		Query query=em.createNativeQuery("Select * From tejaswi_courses where id=?",Course.class);
		query.setParameter(1, 1001L);
		List resultList=query.getResultList();
		logger.info("find by id using native query->{} ",resultList);
	}
	*/
}
