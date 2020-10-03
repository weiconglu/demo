package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	/**
	 * 获取所有用户
	 * @return
	 */
	List<User> getAllUser();
	
	/**
	 * 根据用户的id获取用户
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);

}
