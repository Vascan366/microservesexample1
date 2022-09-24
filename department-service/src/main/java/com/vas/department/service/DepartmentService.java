package com.vas.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vas.department.controller.DepartmentController;
import com.vas.department.entity.Department;
import com.vas.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
public class DepartmentService {
	//logger object
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public Department saveDepartment(Department department) {
		logger.info("Inside saveDepartment method of DepartmentService");
		return departmentRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		logger.info("inside findDepartmentById method of DepartmentService");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
