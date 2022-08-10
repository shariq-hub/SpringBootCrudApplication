package com.example.demo.demoController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DemoEntity.DepartmentEntity;
import com.example.demo.demoRepo.DepartmentEntityRepo;
import com.example.demo.demoService.DepartmentService;
import com.example.demo.demoService.StudentService;
import com.example.demo.request.DepartmentRequest;
import com.example.demo.request.StudentRequest;

@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DepartmentEntityRepo departmentEntityRepo;
	
	
	
	@PostMapping("/AddDepartment")
    public ResponseEntity<Object> AddDepartment(@RequestBody DepartmentRequest departmentRequest)
    {	
        return new ResponseEntity<Object>("Department Added Successfully!",HttpStatus.OK);
    }
	@GetMapping("/getDepartment/{id}")
	public ResponseEntity<Object> getDepartment(@PathVariable(name="id")int id ) {
		DepartmentRequest departmentRequest=departmentService.getDepartment(id);
		if(departmentRequest==null) {
			return new ResponseEntity<Object>("Department Not Found with this Id",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Object>(departmentRequest,HttpStatus.OK);
	}
	

}
