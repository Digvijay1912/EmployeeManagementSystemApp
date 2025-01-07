package com.empmngsys.EmployeeManagementSystemApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.empmngsys.EmployeeManagementSystemApp.model.Users;
import com.empmngsys.EmployeeManagementSystemApp.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		return userService.register(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return userService.verify(user);
	}
}
