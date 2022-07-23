package com.example.mybatisStudent.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.mybatisStudent.dto.RequestUserDto;
import com.example.mybatisStudent.dto.ResponseUserDto;

@Mapper
public interface UserMapper {
	
	final String createUser = 
			"insert into `user` (`id`,`email`,`password`) values (#{id}, #{email}, #{password})";
	final String updateByUserId = 
			"update `user` " + "set email= #{email}, password=#{password} where id= #{id}";
	final String deleteByUserId = "delete from user where id= #{id}";
	final String selectOneById = "select * from user where id= #{id}";
	final String selectOneByEmail = "select * from user where email= #{email}";
	final String selectAll = "select * from user";
	
	@Insert(createUser)
	@Options(useGeneratedKeys = true , keyProperty = "id")
	void createUser(RequestUserDto requestUserDto);
	
	@Update(updateByUserId)
	void updateByUserId(RequestUserDto requestUserDto);
	
	@Delete(deleteByUserId)
	void deleteByUserId(RequestUserDto requestUserDto);
	
	@Select(selectOneById)
	ResponseUserDto selectOneById(RequestUserDto requestUserDto);
	
	@Select(selectOneByEmail)
	ResponseUserDto selectOneByEmail(RequestUserDto requestUserDto);
	
	@Select(selectAll)
	List<ResponseUserDto> selectAll();
	
}
