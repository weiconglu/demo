package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {

	@Select(value = { "select * from user" })
	List<User> getAllUser();

	@Select(value = { "select * from user where id=#{id}" })
	User getUserById(Integer id);

	@Insert(value = {
			"insert into user(name,password,gender,birthday) values(#{name},#{password},#{gender},#{birthday})" })
	void addUser(String name, String password, String gender, String birthday);

}
