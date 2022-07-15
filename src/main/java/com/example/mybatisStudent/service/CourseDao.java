package com.example.mybatisStudent.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatisStudent.dto.RequestCourseDto;
import com.example.mybatisStudent.dto.ResponseCourseDto;
import com.example.mybatisStudent.repository.CourseMapper;

@Repository
public class CourseDao {
	
	@Autowired
	private CourseMapper courseMapper;
	
	public void createCourse(RequestCourseDto requestCourseDto) {
		// TODO Auto-generated method stub
		courseMapper.createCourse(requestCourseDto);
	}
	
	public List<ResponseCourseDto> selectAll() {
		// TODO Auto-generated method stub
		return courseMapper.selectAll();
	}
	
	public ResponseCourseDto selectById(RequestCourseDto requestCourseDto) {
		ResponseCourseDto responseCourseDto = 
				courseMapper.selectById(requestCourseDto);
		
		return responseCourseDto;
	}
	
	public ResponseCourseDto selectLastRow() {
		// TODO Auto-generated method stub
		ResponseCourseDto responseCourseDto = 
				courseMapper.selectLastRow();
		
		return responseCourseDto;
	}
}
