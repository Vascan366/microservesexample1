package com.vas.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vas.user.VO.ResponseTemplateVO;
import com.vas.user.entity.User;
import com.vas.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
        logger.info("Inside saveUser method of UserController");		
		return userService.saveUser(user);
	}
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        logger.info("Inside getUserWithDepartmentr method of UserController");			
		return userService.getUserWithDepartment(userId);		
	}

}
