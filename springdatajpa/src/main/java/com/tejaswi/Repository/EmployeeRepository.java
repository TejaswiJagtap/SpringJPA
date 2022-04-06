package com.tejaswi.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tejaswi.Entity.Employee;

@Repository
public class EmployeeRepository 
{
	@Autowired
	EntityManager em;
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	public void findAllEmployee()
	{
		Query query=em.createQuery("Select e From Employee e");
		List employee=query.getResultList();
		logger.info("empployee details->{}",employee);
	}
	
	public void findAllParttime_Employee()
	{
		Query query=em.createQuery("Select e From ParttimeEmployee e");
		List employee=query.getResultList();
		logger.info("empployee details->{}",employee);
	}
	
	@Transactional
	public void insertEmployee(Employee employee)
	{
		em.persist(employee);
	}
	
}
