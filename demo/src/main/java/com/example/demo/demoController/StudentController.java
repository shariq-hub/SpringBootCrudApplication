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

import com.example.demo.demoRepo.DepartmentEntityRepo;
import com.example.demo.demoRepo.StudentEntityRepo;
import com.example.demo.demoService.StudentService;
import com.example.demo.request.StudentRequest;
@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	StudentEntityRepo studentEntityRepo;
	
	@Autowired
	DepartmentEntityRepo departmentEntityRepo;
	@PostMapping
    public ResponseEntity<Object> addStudent(
       @RequestBody StudentRequest studentRequest)
    {
		if(departmentExist(studentRequest.getDepartment_id())==true){
			 studentService.AddStudent(studentRequest);	
			 return new ResponseEntity<Object>("Student Added Successfully",HttpStatus.OK);
			
		}
		return new ResponseEntity<Object>("Department Not Found!",HttpStatus.NOT_FOUND);
         
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getStudent(@PathVariable(name="id") int id) {
		StudentRequest studentRequest=new StudentRequest();
		studentRequest=studentService.getStudent(id);
		if(studentExist(id)) {
		return new ResponseEntity<Object>(studentRequest,HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Student Not Found With this Id",HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable(name="id") int id,@RequestBody StudentRequest studentRequest){
		if(studentExist(id)) {
		studentService.updateStudent(id,studentRequest);
		return new ResponseEntity<Object>("Student Update Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<Object>("Student Not Found with this Id",HttpStatus.NOT_FOUND);
	}
	
	private boolean departmentExist(int id) {
		return departmentEntityRepo.existsById(id);
	}
	private boolean studentExist(int id) {
		return studentEntityRepo.existsById(id);
	}
	

}
