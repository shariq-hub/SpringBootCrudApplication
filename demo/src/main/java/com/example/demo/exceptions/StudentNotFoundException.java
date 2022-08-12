package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentNotFoundException extends RuntimeException {
	
	private int id;

	public StudentNotFoundException(int id) {
		super(String.format("Student Not found with id : %s",id));
		this.id = id;
	}
	
	
	
	
}
