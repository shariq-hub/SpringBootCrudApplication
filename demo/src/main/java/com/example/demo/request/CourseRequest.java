package com.example.demo.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;

@Data
public class CourseRequest {
	private int id;
	private String course_name;
	@JsonIgnore
	private Integer teacher_id;
	@JsonIgnore
	private TeacherRequest teacherEntity;
}
