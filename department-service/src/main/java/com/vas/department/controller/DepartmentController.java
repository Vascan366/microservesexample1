package com.vas.department.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vas.department.entity.Department;
import com.vas.department.service.DepartmentService;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
	//logger object
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
		
	
	@Autowired
	private DepartmentService departmentService;
    
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
        department.getDepartmentName();
		//System.out.println("DepartmentName: "+department.getDepartmentName());
		logger.info("Inside saveDepartment method of DepartmentController");
		return departmentService.saveDepartment(department);
	}
	
	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		logger.info("inside findDepartmentById method of departmentController");
		return departmentService.findDepartmentById(departmentId);
	}
}
