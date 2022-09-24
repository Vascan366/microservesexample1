package com.vas.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {
	
	@GetMapping("/userServiceFallBack")
	public String userServiceFallBackMethod() {
		return "user service taking longer than expected. Please try again later";
	}

	@GetMapping("/departmentServiceFallBack")
	public String departmentServiceFallBackMethod() {
		return "department service taking longer than expected. Please try again later";
	}	
	
}
