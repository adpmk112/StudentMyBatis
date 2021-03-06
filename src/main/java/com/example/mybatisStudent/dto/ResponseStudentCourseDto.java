package com.example.mybatisStudent.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service("responseStudentCourseDto")
public class ResponseStudentCourseDto {
	private int student_id, course_id;
	private String student_name, birth, gender, phone, education, course_name;
}
