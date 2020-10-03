package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	// 获取所有用户
	@GetMapping("/getAllUser")
	public String showAllUser() {
		
		List<User> userList = userService.getAllUser();
		
		if (null == userList) {
			return "未找到任何用户";
		}
		
		String line = "";
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			line += user.toString()+"<br>";
		}
		return line;
	}
	
	// 获取指定id的用户
	@GetMapping("/getById/{id}")
	public String getUserById(@PathVariable Integer id) {
		User user = userService.getUserById(id);
		if (null == user) {
			return "没有id为"+id+"的用户";
		}
		return user.toString();
	}

}
