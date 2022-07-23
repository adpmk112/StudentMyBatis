package com.example.mybatisStudent.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service("responseCourseDto")
public class ResponseCourseDto {
	Integer course_id;
	String name;
}
