package com.example.demo.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


public class DepartmentRequest {
	
	private String name;
	private String description;
	private List<CourseRequest> courseEntity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonIgnore
	public List<CourseRequest> getCourseEntity() {
		return courseEntity;
	}
	public void setCourseEntity(List<CourseRequest> courseEntity) {
		this.courseEntity = courseEntity;
	}
	
	
	

}
