package com.example.mybatisStudent.model;

import lombok.Data;

@Data
public class StudentCourseBean {
	private int student_id, course_id;
	private String student_name, birth, gender, phone, education, course_name;
}
