package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {

	@Select(value = {"select * from user"})
	List<User> getAllUser();
	
	@Select(value = {"select * from user where id=#{id}"})
	User getUserById(Integer id);

}
