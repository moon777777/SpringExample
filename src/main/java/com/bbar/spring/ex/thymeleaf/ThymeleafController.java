package com.bbar.spring.ex.thymeleaf;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
	
	@GetMapping("/thymeleaf/ex01")
	public String ex01() {
		return "thymeleaf/ex01";
	}

}
