package com.bbar.spring.ex.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Ex01Controller {
	
	// 간단한 html 코드를 response로 만드는 페이지
	@ResponseBody
	@RequestMapping("/lifecycle/ex01/1")
	public String stringResponse() {
		return "<h1>예제 1번 문자열 담기</h1>";
	}
	
	// 앱 데이터를 response 로 만드는 페이지
	@ResponseBody
	@RequestMapping("/lifecycle/ex01/2")
	public Map<String, Integer> mapResponse() {
		// 과일이름 : 가격
		Map<String, Integer> fruitMap = new HashMap<>();
		
		fruitMap.put("apple", 1500);
		fruitMap.put("banana", 4500);
		fruitMap.put("orange", 1300);
		
		return fruitMap;
		
	}
}
