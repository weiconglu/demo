package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

//@Mapper
public interface UserMapper {

	// 指定为List时返回值可能长度为0，但不会为null
	@Select(value = { "select * from user" })
	List<User> getAll();
	
	@Select(value = { "select * from user where id=100" })
	List<User> get100();

	// 指定为Model时，返回值可能为null
	@Select(value = { "select * from user where id=#{id}" })
	User getById(Integer id);
	
	/*
	 * 执行增/删/改操作，均返回Integer，表示受影响的行数
	 */
	Integer add(User user);

}
