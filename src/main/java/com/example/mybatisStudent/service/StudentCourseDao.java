package com.example.mybatisStudent.service;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatisStudent.dto.RequestCourseDto;
import com.example.mybatisStudent.dto.RequestStudentCourseDto;
import com.example.mybatisStudent.dto.RequestStudentDto;
import com.example.mybatisStudent.dto.ResponseStudentCourseDto;

@Repository
public class StudentCourseDao {
	
	public void createStudent_course(RequestStudentDto requestStudentDto, RequestCourseDto requestCourseDto) {
		String sql = "insert into student_course (student_id, course_id) values(?,?)";
	}
	
	public void deleteStudentCourseByCourseId(RequestCourseDto requestCourseDto) {
		String sql = "Delete from `student_course` where `course_id` = ? ";
	}

	public List<ResponseStudentCourseDto> selectOneById(RequestStudentCourseDto requestStudentCourseDto) {
		String sql = "select s.`id` AS `student_id`, s.`name` AS `student_name`, s.`birth`, s.`gender`, "
				+ "s.`phone`, s.`education`, c.`id` AS `course_id`, c.`name` AS `course_name` from `student` "
				+ "s join `student_course` sc join `course` c on s.`id`=sc.`student_id` and c.id=sc.`course_id` "
				+ "where s.`id`=?";
		
		List<ResponseStudentCourseDto>resStudentCourseDtoList = new ArrayList<>();
		
		return resStudentCourseDtoList;
	}

	public List<ResponseStudentCourseDto> selectAllStudentwithCourseName() {

		String sql = "select s.`id` AS `student_id` ,s.`name` AS `student_name`,"
				+ "s.`birth`, s.`gender`, s.`phone`, s.`education`,"
				+ "c.`id` AS `course_id`,  c.`name` AS `course_name` from "
				+ "`student` s join `student_course` sc join `course` c on"
				+ " s.`id`=sc.`student_id` and c.`id`=sc.`course_id`;";
		
		List<ResponseStudentCourseDto>resStudentCourseDtoList = new ArrayList<>();
		
		return resStudentCourseDtoList;
	}
}
