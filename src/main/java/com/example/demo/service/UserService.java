package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	/**
	 * 获取所有用户
	 * @return
	 */
	List<User> getAll();
	
	/**
	 * 根据用户的id获取用户
	 * @param id
	 * @return
	 */
	User getById(Integer id);
	
	/**
	 * 
	 * @param user
	 * @return
	 */
	Integer add(User user);

	List<User> get100();

}
