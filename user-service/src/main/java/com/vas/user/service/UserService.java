package com.vas.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.vas.user.VO.Department;
import com.vas.user.VO.ResponseTemplateVO;
import com.vas.user.entity.User;
import com.vas.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	
	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserService.class);	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
        logger.info("Inside saveUser method of UserService");		
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
        logger.info("Inside getUserWithDepartment method of UserService");	
        
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        
        Department departmemnt = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ 
                                     user.getDepartmentId(), Department.class);

        vo.setUser(user);
        vo.setDepartment(departmemnt);
        
        return vo;
        
	}

}
