package com.example.demo.demoServiceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DemoEntity.CourseEntity;
import com.example.demo.DemoEntity.DepartmentEntity;
import com.example.demo.DemoEntity.TeacherEntity;
import com.example.demo.demoRepo.CourseEntityRepo;
import com.example.demo.demoRepo.DepartmentEntityRepo;
import com.example.demo.demoRepo.TeacherEntityRepo;
import com.example.demo.demoService.CourseService;
import com.example.demo.exceptions.ResourceNotFoundException;
import com.example.demo.request.CourseRequest;

@Service
public class CourseServiceImplementation implements CourseService {
	@Autowired
	CourseEntityRepo courseEntityRepo;
	@Autowired
	TeacherEntityRepo teacherEntityRepo;
	
	@Autowired
	DepartmentEntityRepo departmentEntityRepo;
	
	@Autowired
	ModelMapper modelMapper;

	public void AddCourse(CourseRequest courseRequest,int dep_id,int tea_id) {
		CourseEntity courseEntity=new CourseEntity();
		DepartmentEntity departmentEntity=new DepartmentEntity();
		TeacherEntity teacherEntity=new TeacherEntity();
		teacherEntity=teacherEntityRepo.findById(tea_id).orElseThrow(()->new ResourceNotFoundException("Teacher", "Teacher id:", tea_id));
		departmentEntity=departmentEntityRepo.findById(dep_id).orElseThrow(()->new ResourceNotFoundException("Department", "Department id:", tea_id));
		courseEntity=modelMapper.map(courseRequest, CourseEntity.class);
		courseEntity.setTeacherEntity(teacherEntity);
		courseEntity.setDepartmentEntity(departmentEntity);
		courseEntityRepo.save(courseEntity);
	}
	
	
	
    public CourseRequest getCourse(int id) {
    	CourseEntity courseEntity=courseEntityRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course","Course_id",id));
    	ModelMapper modelMapper=new ModelMapper();
    	CourseRequest courseRequest=new CourseRequest();
    	courseRequest=modelMapper.map(courseEntity, CourseRequest.class);
    	return courseRequest;
    }

    public void updateCourse(CourseRequest courseRequest,int id) {
    	CourseEntity courseEntity=new CourseEntity();
    	courseEntity=courseEntityRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course","Course_id",id));
    	courseEntity.setCourse_name(courseRequest.getCourse_name());
    	//courseEntity.getTeacherEntity().setId(courseRequest.getTeacher_id());
    	//courseEntity.setTeacherEntity(courseRequest.getTeacher_id());
    	courseEntityRepo.save(courseEntity);
    	
    }
    
    public void deleteCourse(int id) {
    	CourseEntity courseEntity=courseEntityRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course","Course_id",id));
    	courseEntityRepo.delete(courseEntity);
    }

	
	

}
