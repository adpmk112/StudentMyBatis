package com.example.mybatisStudent.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.mybatisStudent.dto.RequestCourseDto;
import com.example.mybatisStudent.dto.RequestStudentCourseDto;
import com.example.mybatisStudent.dto.RequestStudentDto;
import com.example.mybatisStudent.dto.ResponseStudentCourseDto;

@Mapper
public interface StudentCourseMapper {
	
	final String createStudent_course = 
			"insert into student_course (student_id, course_id) values (#{student_id} , #{course_id})";
	
	final String deleteStudentCourseByCourseId = 
			"Delete from `student_course` where `course_id` = #{course_id} ";
	
	final String selectOneById = 
			"select s.`student_id`, s.`name` AS `student_name`, s.`birth`,s.`gender`,s.`phone`,s.`education`, "
					+ "c.`course_id`, c.`name` AS `course_name` from `student` s join `student_course` sc join"
					+ " `course` c on s.`student_id`=sc.`student_id` and c.`course_id` =sc.`course_id`"
					+ "where s.student_id = #{student_id};";
	
	final String selectAllStudentwithCourseName = 
			"select s.`student_id`, s.`name` AS `student_name`, s.`birth`,s.`gender`,s.`phone`,s.`education`, "
			+ "c.`course_id`, c.`name` AS `course_name` from `student` s join `student_course` sc join"
			+ " `course` c on s.`student_id`=sc.`student_id` and c.`course_id` =sc.`course_id`;";

	
	@Insert(createStudent_course)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void createStudent_course(@Param("student_id")Integer student_id,
			@Param("course_id") Integer course_id);
	
	@Delete(deleteStudentCourseByCourseId)
	void deleteStudentCourseByCourseId(RequestCourseDto requestCourseDto);
	
	@Select(selectOneById)
	List<ResponseStudentCourseDto> selectOneById(RequestStudentCourseDto requestStudentCourseDto);
	
	@Select(selectAllStudentwithCourseName)
	List<ResponseStudentCourseDto> selectAllStudentwithCourseName();
}
