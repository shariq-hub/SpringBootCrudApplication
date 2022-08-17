package com.example.demo.demoServiceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DemoEntity.CourseEntity;
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
	
    public CourseRequest getCourse(int id) {
    	CourseEntity courseEntity=courseEntityRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Course","Course_id",id));
    	ModelMapper modelMapper=new ModelMapper();
    	CourseRequest courseRequest=new CourseRequest();
    	courseRequest=modelMapper.map(courseEntity, CourseRequest.class);
    	courseRequest.setTeacher_id(courseEntity.getTeacherEntity().getId());
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
