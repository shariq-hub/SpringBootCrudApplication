package com.example.demo.demoController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demoRepo.DepartmentEntityRepo;
import com.example.demo.demoService.DepartmentService;
import com.example.demo.request.ApiResponse;
import com.example.demo.request.CourseRequest;
import com.example.demo.request.DepartmentRequest;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DepartmentEntityRepo departmentEntityRepo;
	
	
	
	@PostMapping("/")
    public ResponseEntity<Object> AddDepartment(@RequestBody DepartmentRequest departmentRequest)
    {	
		departmentService.AddDepartment(departmentRequest);
        return new ResponseEntity<Object>(new ApiResponse("Department Added Successfully",true),HttpStatus.CREATED);
    }
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getDepartment(@PathVariable(name="id")int id ) {
		DepartmentRequest departmentRequest=departmentService.getDepartment(id);
		return new ResponseEntity<Object>(departmentRequest,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteDepartment(@PathVariable int id){
	departmentService.deleteDepartment(id);
	return new ResponseEntity<Object>(new ApiResponse("Department Deleted Successfully",true),HttpStatus.OK);
	}
	
	

}
