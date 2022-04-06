package com.tejaswi.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.tejaswi.Entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseRepository extends JpaRepository<Course, Long>
{
	List<Course> findByCoursename(String coursename);
	
	List<Course> findByCoursenameAndId(String coursename,Long id);
	
	List<Course> findByCoursenameOrderByIdDesc(String coursename);
	
	List<Course> countByCoursename(String name);
	
}
