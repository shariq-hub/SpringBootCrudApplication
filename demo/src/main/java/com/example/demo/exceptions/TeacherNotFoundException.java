package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherNotFoundException extends RuntimeException {
	
	private int id;

	public TeacherNotFoundException(int id) {
		super(String.format("Teacher Not found with id : %s",id));
		this.id = id;
	}
	
	

}
