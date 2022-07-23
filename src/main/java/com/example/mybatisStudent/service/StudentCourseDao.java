package com.example.mybatisStudent.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatisStudent.dto.RequestCourseDto;
import com.example.mybatisStudent.dto.RequestStudentCourseDto;
import com.example.mybatisStudent.dto.RequestStudentDto;
import com.example.mybatisStudent.dto.ResponseStudentCourseDto;
import com.example.mybatisStudent.repository.StudentCourseMapper;


@Repository
public class StudentCourseDao {
	
	@Autowired
	StudentCourseMapper studentCourseMapper;
	
	public void createStudent_course(Integer student_id, Integer course_id) {
		studentCourseMapper.createStudent_course(student_id, course_id);
	}
	
	public void deleteStudentCourseByCourseId(RequestCourseDto requestCourseDto) {
		studentCourseMapper.deleteStudentCourseByCourseId(requestCourseDto);
	}

	public List<ResponseStudentCourseDto> selectOneById(RequestStudentCourseDto requestStudentCourseDto) {
		
		List<ResponseStudentCourseDto>resStudentCourseDtoList = 
				studentCourseMapper.selectOneById(requestStudentCourseDto);
		
		return resStudentCourseDtoList;
	}

	public List<ResponseStudentCourseDto> selectAllStudentwithCourseName() {
		
		List<ResponseStudentCourseDto>resStudentCourseDtoList =
				studentCourseMapper.selectAllStudentwithCourseName();
		
		return resStudentCourseDtoList;
	}
}
