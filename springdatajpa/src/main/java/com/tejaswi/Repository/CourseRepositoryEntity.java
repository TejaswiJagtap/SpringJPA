package com.tejaswi.Repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tejaswi.Entity.Course;
import com.tejaswi.Entity.ReviewRating;
import com.tejaswi.Entity.Reviews;

@Repository
public class CourseRepositoryEntity
{
	@Autowired
	EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public Course findById(Long id)
	{
		return em.find(Course.class, id);
	}
	
	@Transactional
	public void deleteById(Long id)
	{
		Course course=em.find(Course.class, id);
		em.remove(course);
	}
	
	@Transactional
	public void add_reviews()
	{
		Course course=em.find(Course.class, 1005L);
		Reviews review1=new Reviews("good course", ReviewRating.FIVE);
		Reviews review2=new Reviews("very good course", ReviewRating.SEVEN);
		course.addReviews(review1);
		course.addReviews(review2);
		
		review1.setCourse(course);
		review2.setCourse(course);

		em.persist(review2);
		em.persist(review1);
	}
	
	@Transactional
	public void update_reviews()
	{
		Course course=em.find(Course.class, 1001L);
		logger.info("review for 1001->{}",course.getReviews());
		
		Reviews review=new Reviews("excellent", ReviewRating.FIVE);
		course.addReviews(review);
		review.setCourse(course);
		em.persist(review);
		
	}
}
