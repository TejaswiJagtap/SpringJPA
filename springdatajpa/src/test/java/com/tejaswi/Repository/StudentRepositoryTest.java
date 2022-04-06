package com.tejaswi.Repository;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tejaswi.SpringdatajpaApplication;
import com.tejaswi.Entity.Address;
import com.tejaswi.Entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringdatajpaApplication.class)
public class StudentRepositoryTest 
{
	@Autowired
	EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Test
	@Transactional
	public void retrive_details_from_student()
	{
		Student student=em.find(Student.class, 103);
		student.setAddress(new Address("Hous No 3", "Munbai"));
		em.flush();
		logger.info("student details->{}",student);
	}	
}
