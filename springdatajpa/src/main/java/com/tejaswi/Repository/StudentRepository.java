package com.tejaswi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tejaswi.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	
}
