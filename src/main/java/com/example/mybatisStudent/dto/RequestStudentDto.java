package com.example.mybatisStudent.dto;

import org.springframework.stereotype.Service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service("requestStudentDto")
public class RequestStudentDto {
	
	private Integer id;
	private String name, birth, gender, phone, education;
}
