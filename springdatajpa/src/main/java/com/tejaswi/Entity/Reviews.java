package com.tejaswi.Entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tejaswi_reviews")
public class Reviews
{
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ReviewRating rating;
	
	@ManyToOne
	private Course course;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ReviewRating getRating() {
		return rating;
	}
	public void setRating(ReviewRating rating) {
		this.rating = rating;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Reviews() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reviews(Long id, String description, ReviewRating rating, Course course) {
		super();
		this.id = id;
		this.description = description;
		this.rating = rating;
		this.course = course;
	}
	public Reviews(String description, ReviewRating rating) {
		super();
		this.description = description;
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Reviews [id=" + id + ", description=" + description + ", rating=" + rating + ", course=" + course + "]";
	}
	
	
}
