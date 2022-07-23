package com.example.mybatisStudent.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatisStudent.dto.RequestUserDto;
import com.example.mybatisStudent.dto.ResponseUserDto;
import com.example.mybatisStudent.repository.UserMapper;

@Repository
public class UserDao {
	
	@Autowired
	UserMapper userMapper;
	
	public void createUser(RequestUserDto requestUserDto) {
		// TODO Auto-generated method stub
		userMapper.createUser(requestUserDto);
	}
	
	public void updateByUserId(RequestUserDto requestUserDto) {
		// TODO Auto-generated method stub
		userMapper.updateByUserId(requestUserDto);
	}

	public void deleteByUserId(RequestUserDto requestUserDto) {
		userMapper.deleteByUserId(requestUserDto);
	}

	public ResponseUserDto selectOneById(RequestUserDto requestUserDto) {
		
		ResponseUserDto responseUserDto = userMapper.selectOneById(requestUserDto);
		
		return responseUserDto;
	}

	public ResponseUserDto selectOneByEmail(RequestUserDto requestUserDto) {
		
		ResponseUserDto responseUserDto = userMapper.selectOneByEmail(requestUserDto);
	
		return responseUserDto;
	}

	public List<ResponseUserDto> selectAll() {
		
		List<ResponseUserDto>resUserDtoList = userMapper.selectAll();
		
		return resUserDtoList;
	}
	
}
