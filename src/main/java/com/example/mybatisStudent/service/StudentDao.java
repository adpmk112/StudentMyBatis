package com.example.mybatisStudent.service;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatisStudent.dto.RequestStudentDto;
import com.example.mybatisStudent.dto.ResponseStudentCourseDto;
import com.example.mybatisStudent.dto.ResponseStudentDto;

@Repository
public class StudentDao {	
	
	public void createStudent(RequestStudentDto requestStudentDto) {
		String sql = "insert into `student` "
				+ "(`id`,`name`,`birth`,`gender`,`phone`,`education`) "
				+ "values (?,?,?,?,?,?)";
		
	
	}
	
	public void updateByStudentId(RequestStudentDto requestStudentDto) {
		String sql = "update `student` set name=?,birth=?,gender=?,"
				+ "phone=?,education=? where id=?";
		
	}
	
	public void deleteByStudentId(RequestStudentDto requestStudentDto) {
		String sql = "delete from student where id=?";
	}
	
	public ResponseStudentDto selectOneById(RequestStudentDto requestStudentDto) {
	    
		ResponseStudentDto responseStudentDto = new ResponseStudentDto();
		
		String sql = "select * from student where id=?";
	    
		return responseStudentDto;
	}
	
	public List<ResponseStudentDto> selectOneByName(RequestStudentDto requestStudentDto) {
	    String sql = "select * from student where name=?";
	    
	    List<ResponseStudentDto>resStudentDtoList = new ArrayList<>();
		
		return resStudentDtoList;
	}
	
	public List<ResponseStudentDto> selectAll() {
	    
	    String sql = "select * from student";
	    List<ResponseStudentDto>resStudentDtoList = new ArrayList<>();
		
		return resStudentDtoList;
	}
	
	public ResponseStudentDto selectLastRow() {
		ResponseStudentDto responseStudentDto = new ResponseStudentDto();
		
		String sql = "SELECT `id` FROM `student` ORDER BY `id` DESC LIMIT 1";
		
		return responseStudentDto;
	}
}
