package com.example.demo.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demoRepo.CourseEntityRepo;
import com.example.demo.demoService.CourseService;
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
		return new ResponseEntity<Object>("Course Updated Successfully",HttpStatus.OK);
	}	
	

}
