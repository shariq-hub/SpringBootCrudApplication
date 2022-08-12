package com.example.demo.demoService;

import org.springframework.http.ResponseEntity;

import com.example.demo.request.StudentRequest;

public interface StudentService {
	
	public ResponseEntity<Object> AddStudent(StudentRequest studentRequest);
	public StudentRequest getStudent(int id);
	public void updateStudent(int id,StudentRequest studentEntity);
	public void deleteStudent(int id);
}
