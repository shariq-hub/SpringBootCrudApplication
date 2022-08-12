package com.example.demo.exceptions;

public class CourseNotFoundException extends RuntimeException {
	
	private int id;

	public CourseNotFoundException(int id) {
		super(String.format("Course Not found with id : %s",id));
		this.id = id;
	}
	
	

}
