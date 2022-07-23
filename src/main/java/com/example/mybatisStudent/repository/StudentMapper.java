package com.example.mybatisStudent.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.mybatisStudent.dto.RequestStudentDto;
import com.example.mybatisStudent.dto.ResponseStudentDto;

@Mapper
public interface StudentMapper {
		
	final String createStudent = "insert into `student` "
			+ "(`student_id`,`name`,`birth`,`gender`,`phone`,`education`) "
			+ "values (#{student_id} , #{name} , #{birth} , #{gender} , #{phone} , #{education} )";
	
	final String updateByStudentId =
			"update `student` set name= #{name} ,birth= #{birth} ,gender= #{gender} ,"
			+ "phone= #{phone} ,education= #{education} where student_id = #{student_id}";
	
	final String deleteByStudentId = "delete from student where student_id= #{student_id} ";
	
	final String selectOneById = "select * from student where student_id= #{student_id}";
	
	final String selectOneByName = "select * from student where name= #{name}";
	
	final String selectAll = "select * from student";
	
	final String selectLastRow = "SELECT `student_id` FROM `student` ORDER BY `student_id` DESC LIMIT 1";
	
	@Insert(createStudent)
	void createStudent(RequestStudentDto requestStudentDto);
	
	@Update(updateByStudentId)
	void updateByStudentId(RequestStudentDto requestStudentDto);
	
	@Delete(deleteByStudentId)
	void deleteByStudentId(RequestStudentDto requestStudentDto);
	
	@Select(selectOneById)
	ResponseStudentDto selectOneById(RequestStudentDto requestStudentDto);
	
	@Select(selectOneByName)
	List<ResponseStudentDto> selectOneByName(RequestStudentDto requestStudentDto);
	
	@Select(selectAll)
	List<ResponseStudentDto> selectAll();
	
	@Select(selectLastRow)
	ResponseStudentDto selectLastRow();

}
