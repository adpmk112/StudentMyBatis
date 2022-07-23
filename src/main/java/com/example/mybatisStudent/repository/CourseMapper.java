package com.example.mybatisStudent.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.mybatisStudent.dto.RequestCourseDto;
import com.example.mybatisStudent.dto.ResponseCourseDto;

@Mapper
public interface CourseMapper {
	
	final String create = 
			"insert into `course` (`name`) values (#{name})";
	final String selectAll = "SELECT * FROM course";
	final String selectById = 
			"SELECT `name` FROM `course` WHERE `course_id`= #{course_id}";
	final String selectLastRow = 
			"SELECT `course_id` FROM `course` ORDER BY `course_id` DESC LIMIT 1";
	
	@Insert(create)
	@Options(useGeneratedKeys = true,keyProperty = "id")
	void createCourse(RequestCourseDto requestCourseDto);
	
	@Select(selectAll)
	List<ResponseCourseDto> selectAll();
	
	@Select(selectById)
	ResponseCourseDto selectById(RequestCourseDto requestCourseDto);
	
	@Select(selectLastRow)
	ResponseCourseDto selectLastRow();
}
