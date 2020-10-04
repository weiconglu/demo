package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> getAllUser() {
		List<User> userList = userMapper.getAllUser();
		return userList;
	}

	@Override
	public User getUserById(Integer id) {
		User user = userMapper.getUserById(id);
		return user;
	}

	@Override
	public Integer add(User user) {
		return userMapper.add(user);
	}

}
