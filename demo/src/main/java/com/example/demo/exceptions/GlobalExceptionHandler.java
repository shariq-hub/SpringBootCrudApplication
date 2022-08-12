package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.request.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Object> departmentNotFoundExceptionHandler(DepartmentNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<Object>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<Object> studentNotFoundException(StudentNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<Object>(apiResponse,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(TeacherNotFoundException.class)
	public ResponseEntity<Object> teacherNotFoundException(TeacherNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<Object>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CourseNotFoundException.class)
	public ResponseEntity<Object> courseNotFoundException(CourseNotFoundException ex){
		String message=ex.getMessage();
		ApiResponse apiResponse=new ApiResponse(message,false);
		return new ResponseEntity<Object>(apiResponse,HttpStatus.NOT_FOUND);
	}

}
