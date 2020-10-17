package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.FaceInfo;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	// 获取所有用户
	@GetMapping("/getAll")
	public String showAllUser() {

		List<User> userList = userService.getAll();

		if (null == userList) {
			return "未找到任何用户";
		}

		String line = "";
		for (int i = 0; i < userList.size(); i++) {
			User user = userList.get(i);
			line += user.toString()+"\n";
		}
		return line;
	}

	// 获取指定id的用户
	@GetMapping("/getById/{id}")
	public String getUserById(@PathVariable Integer id) {
		User user = userService.getById(id);
		if (null == user) {
			return "没有id为" + id + "的用户";
		}
		return user.toString();
	}

	// 框架会自动检查请求参数是不是为null
	@PostMapping("/add")
	public String add(@RequestParam String name, @RequestParam String gender, @RequestParam String birthday) {
		
		User user = new User();
		user.setName(name);
		user.setGender(gender);
		user.setBirthday(birthday);
		
		userService.add(user);
		return "添加成功";
	}
	
	@PostMapping("/getFaces")
	public String getFaces(@RequestBody FaceInfo faceInfo) {
		
		List<Map<String, Object>> faces = faceInfo.getFaces();
		Map<String, Object> map = faces.get(0);
		
		System.out.println(map.get("personId"));
		
		return "收到";
	}

}
