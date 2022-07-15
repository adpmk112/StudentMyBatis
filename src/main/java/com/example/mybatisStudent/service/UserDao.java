package com.example.mybatisStudent.service;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.mybatisStudent.dto.RequestUserDto;
import com.example.mybatisStudent.dto.ResponseStudentDto;
import com.example.mybatisStudent.dto.ResponseUserDto;

@Repository
public class UserDao {
	
	public void createUser(RequestUserDto requestUserDto) {
		// TODO Auto-generated method stub
		String sql = "insert into `user` (`id`,`email`,`password`) values (?,?,?)";
	}
	
	public void updateByUserId(RequestUserDto requestUserDto) {
		// TODO Auto-generated method stub
		String sql = "update `user` " + "set email=?,password=? where id=?";
	}

	public void deleteByUserId(RequestUserDto requestUserDto) {
		String sql = "delete from user where id=?";
	}

	public ResponseUserDto selectOneById(RequestUserDto requestUserDto) {
		
		ResponseUserDto responseUserDto = new ResponseUserDto();
		
		String sql = "select * from user where id=?";
		
		return responseUserDto;
	}

	public ResponseUserDto selectOneByEmail(RequestUserDto requestUserDto) {
		
		ResponseUserDto responseUserDto = new ResponseUserDto();
		
		String sql = "select * from user where email=?";
	
		return responseUserDto;
	}

	public List<ResponseUserDto> selectAll() {
		String sql = "select * from user";
		List<ResponseUserDto>resUserDtoList = new ArrayList<>();
		
		return resUserDtoList;
	}
}
