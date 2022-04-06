package com.tejaswi.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

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
import org.springframework.data.domain.Sort;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringdatajpaApplication.class)
public class CourseRepositoryTest 
{
	@Autowired
	CourseRepository repository;
	
	@Autowired
	CourseRepositoryEntity courseRepository;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	/*@Test
	public void findAll()
	{
		logger.info("list of course->{}",repository.findAll());
	}
	*/
	@Test
	public void deleteById()
	{
		courseRepository.deleteById(1438L);
		//Course course=courseRepository.findById(1438L);
		//assertNull(course);
	}
	
	/*@Test
	public void Sort()
	{
		//List<Course> course = repository.findAll(Sort.by(Sort.Direction.ASC, "coursename"));
		//logger.info("sorted list->{}",course);
		
		Sort sort=Sort.by(Sort.Direction.DESC,"coursename");
		logger.info("sorted list->{}",repository.findAll(sort));
		
	}
	*/
	/*
	@Test
	public void paging()
	{
		PageRequest pageRequest=PageRequest.of(0, 3);
		Page<Course> firstpage=repository.findAll(pageRequest);
		logger.info("first page:->{}",firstpage.getContent());
		
		Pageable secondPagable=firstpage.nextPageable();
		Page<Course> secondpage=repository.findAll(secondPagable);
		logger.info("second page->{}",secondpage.getContent());
	}
	@Test
	public void findByname()
	{
		logger.info("find by name->{}",repository.findByCoursename("php"));
		
		logger.info("find by name and id->{}",repository.findByCoursenameAndId("spring mvc", 1003L));
		
		logger.info("find by name order by->{}",repository.findByCoursenameOrderByIdDesc("angular js"));
		
		logger.info("count by name->{}",repository.countByCoursename("angular js"));
	}
	*/
	//use a first level cache
	/*@Test
	@Transactional
	public void findById_using_firstlevel_cache()
	{
		Optional<Course> course=repository.findById(1005L);
		logger.info("first level cache retrived->{}",course);
		assertEquals("angular with spring boot",course.get().getCoursename());
		
		Optional<Course> course1=repository.findById(1005L);
		logger.info("first level cache retrived again->{}",course1);
		assertEquals("angular with spring boot",course1.get().getCoursename());
		
	}
	*/
	
}
