package com.bbar.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AjaxController {
	
	// 데이터를 담은 response 구성하는 페이지 (json)
	// API
	// 이름과 생년월일 전달 받고, 이름과 나이를 json으로 구성한 response
	@ResponseBody
	@GetMapping("/ajax/person")
	public Map<String, Object> personInfo(
			@RequestParam("name") String name
			, @RequestParam("birthday") String birthday) {
		
		int year = Integer.parseInt(birthday.substring(0, 4));
		
		int age = 2024 - year;
		
		// {"name":"김인규", "age":29}
		Map<String, Object> personMap = new HashMap<>();
		personMap.put("name", name);
		personMap.put("age", age);
		
		return personMap;
	}
	
	
	// View
	@GetMapping("/ajax/ex01")
	public String ajaxEx() {
		return "ajax/ex01";
	}
	
	// View
		@GetMapping("/ajax/prac")
		public String ajaxprac() {
			return "ajax/prac";
		}

}
