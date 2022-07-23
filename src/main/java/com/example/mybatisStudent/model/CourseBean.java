package com.example.mybatisStudent.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class CourseBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int course_id;
	String name;
}
