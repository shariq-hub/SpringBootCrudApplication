package com.example.demo.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private String user;
	private String fieldname;
	private int fieldvalue;
	public ResourceNotFoundException(String user, String fieldname, int fieldvalue) {
		super(String.format("%s not found with %s : %s", user,fieldname,fieldvalue));
		this.user = user;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}
	
	
	
	

}
