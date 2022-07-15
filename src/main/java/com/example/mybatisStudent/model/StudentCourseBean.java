package com.example.mybatisStudent.model;

import lombok.Data;

@Data
public class StudentCourseBean {
	private int studentId, courseId;
	private String studentName, birth, gender, phone, education, courseName;
}
