package com.example.mybatisStudent.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service("responseStudentDto")
public class ResponseStudentDto {
	
	private Integer student_id;
	private String name, birth, gender, phone, education;
}
