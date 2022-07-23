package com.example.mybatisStudent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatisStudent.dto.RequestStudentDto;
import com.example.mybatisStudent.dto.ResponseStudentDto;
import com.example.mybatisStudent.repository.StudentMapper;

@Repository
public class StudentDao {	
	
	@Autowired
	StudentMapper studentMapper;
	
	public void createStudent(RequestStudentDto requestStudentDto) {
		studentMapper.createStudent(requestStudentDto);
	}
	
	public void updateByStudentId(RequestStudentDto requestStudentDto) {
		studentMapper.updateByStudentId(requestStudentDto);
	}
	
	public void deleteByStudentId(RequestStudentDto requestStudentDto) {
		studentMapper.deleteByStudentId(requestStudentDto);
	}
	
	public ResponseStudentDto selectOneById(RequestStudentDto requestStudentDto) {
	    
		ResponseStudentDto responseStudentDto = studentMapper.selectOneById(requestStudentDto);
	    
		return responseStudentDto;
	}
	
	public List<ResponseStudentDto> selectOneByName(RequestStudentDto requestStudentDto) {
	    
	    List<ResponseStudentDto>resStudentDtoList = 
	    		studentMapper.selectOneByName(requestStudentDto);
		
		return resStudentDtoList;
	}
	
	public List<ResponseStudentDto> selectAll() {
	    
	    List<ResponseStudentDto>resStudentDtoList = 
	    		studentMapper.selectAll();
		
		return resStudentDtoList;
	}
	
	public ResponseStudentDto selectLastRow() {
		ResponseStudentDto responseStudentDto = studentMapper.selectLastRow();
		
		return responseStudentDto;
	}
}
