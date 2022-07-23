package com.example.mybatisStudent.dto;

import org.springframework.stereotype.Service;
import lombok.Getter;
import lombok.Setter;

@Service("requestCourseDto")
@Getter
@Setter
public class RequestCourseDto {
	Integer course_id;
	String name;
}
