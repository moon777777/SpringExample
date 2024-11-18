package com.bbar.spring.ex.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bbar.spring.ex.mvc.service.UserService;

@RequestMapping("/ajax/user")
@Controller
public class NewUserController {
	
	@Autowired
	private UserService userService;
	
	// 사용자 추가 API - Response에 json형태로 그냥 데이터를 담는거다
	@PostMapping("/create")
	@ResponseBody
	public Map<String, String> createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			,@RequestParam("introduce") String introduce) {
		
		int count = userService.addUser(name,  birthday, email, introduce);
		
		Map<String, String> resultMap = new HashMap<>();
		// 성공 {"result":"success"}
		// 실패 {"result":"fail"}
		
		if(count == 1) {
			resultMap.put("result", "success");
		} else {
			resultMap.put("result", "fail");
		}
		
		return resultMap;
	}
	// View
	@GetMapping("/input")
	public String userInput() {
		return "ajax/userInput";
	}
	
	
	
	
	
	
}
