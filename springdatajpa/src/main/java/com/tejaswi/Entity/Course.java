package com.tejaswi.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name="tejaswi_courses")
@Cacheable
@SQLDelete(sql="update tejaswi_courses set is_deleted=true where id=?")
//@Where(clause = "is_deleted = false")
@NamedQuery(name="find_like_pattern",query = "Select c From Course c where coursename like '%spring%'")
@NamedQuery(name="find_all_courses",query = "Select c From Course c")
@NamedQuery(name="find_all_courses_join_fetch",query = "Select c From Course c JOIN FETCH c.student s")

public class Course
{
	
	private static Logger logger = LoggerFactory.getLogger(Course.class);

	@Id
	@GeneratedValue
	private Long id;
	
	private String coursename;
	
	@UpdateTimestamp
	private LocalDateTime updated_date;
	
	@CreationTimestamp
	private LocalDateTime created_date;
	
	@OneToMany(mappedBy = "course")
	private List<Reviews> reviews=new ArrayList<>();
	
	@ManyToMany(mappedBy = "course")
	private List<Student> student =new ArrayList<>();
	
	private boolean is_deleted;
	
	/*@PreRemove
	private void preRemove()
	{
		logger.info("setting deleted to true");
		this.is_deleted=true;
	}
	*/
	public List<Student> getStudent() {
		return student;
	}

	public void addStudent(Student student) {
		this.student.add(student);
	}
	public void removeStudent(Student student) {
		this.student.remove(student);
	}

	public List<Reviews> getReviews() {
		return reviews;
	}

	public void addReviews(Reviews reviews) {
		this.reviews.add(reviews);
	}
	public void removeReviews(Reviews reviews) {
		this.reviews.remove(reviews);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public LocalDateTime getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}

	public LocalDateTime getCreated_date() {
		return created_date;
	}

	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}

	
	@Override
	public String toString() {
		return "Course [id=" + id + ", coursename=" + coursename + ", updated_date=" + updated_date + ", created_date="
				+ created_date + "]";
	}

	public Course(Long id, String coursename, LocalDateTime updated_date, LocalDateTime created_date) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.updated_date = updated_date;
		this.created_date = created_date;
	}

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String coursename) {
		super();
		this.coursename = coursename;
	}
	
	
}
