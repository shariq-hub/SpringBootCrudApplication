package com.example.demo.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentNotFoundException extends RuntimeException {

	private long id;
	
	public DepartmentNotFoundException(int id) {
		super(String.format("Department Not found with id : %s",id));
		this.id=id;
	}
	
}
