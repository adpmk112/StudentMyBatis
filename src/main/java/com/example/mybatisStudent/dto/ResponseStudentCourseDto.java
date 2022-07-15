package com.example.mybatisStudent.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service("responseStudentCourseDto")
public class ResponseStudentCourseDto {
	private int studentId, courseId;
	private String studentName, birth, gender, phone, education, courseName;
}
