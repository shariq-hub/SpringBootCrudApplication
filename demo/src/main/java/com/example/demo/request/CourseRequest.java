package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class CourseRequest {
	
	private int id;
	
	private String course_name;
	
	private Integer teacher_id;
	
	private TeacherRequest teacherEntity;
	
	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	
	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	@JsonIgnore
	public TeacherRequest getTeacherEntity() {
		return teacherEntity;
	}

	public void setTeacherEntity(TeacherRequest teacherEntity) {
		this.teacherEntity = teacherEntity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
