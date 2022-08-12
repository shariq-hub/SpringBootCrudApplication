package com.example.demo.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demoService.CourseService;
import com.example.demo.request.ApiResponse;
import com.example.demo.request.CourseRequest;

@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getCourse(@PathVariable int id) {
		CourseRequest courseRequest=courseService.getCourse(id);
		return new ResponseEntity<Object>(courseRequest,HttpStatus.OK);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateCourse(@RequestBody CourseRequest courseRequest,@PathVariable int id){	
		courseService.updateCourse(courseRequest, id);
		return new ResponseEntity<Object>(new ApiResponse("Course updated Successfully",true),HttpStatus.OK);
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCourse(@PathVariable int id){
		courseService.deleteCourse(id);
		return new ResponseEntity<Object>(new ApiResponse("Course Deleted Successfully",true),HttpStatus.OK);
	}
	
	

}
