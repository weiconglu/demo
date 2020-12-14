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
	public List<User> getAll() {
		List<User> userList = userMapper.getAll();
		return userList;
	}

	@Override
	public User getById(Integer id) {
		User user = userMapper.getById(id);
		return user;
	}

	@Override
	public Integer add(User user) {
		return userMapper.add(user);
	}

	@Override
	public List<User> get100() {
		return userMapper.get100();
	}

	@Override
	public Integer setToManById(Integer id) {
		return userMapper.setToManById(id);
	}

}
