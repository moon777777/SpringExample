package com.bbar.spring.ex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.ex.mvc.domain.User;
import com.bbar.spring.ex.mvc.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce) {
		
		int count =  userRepository.insertUser(name, birthday, email, introduce);
		
		return count;
	}
	
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		return count;
		
	}
	
	 public User getLastUser() {
		 User user = userRepository.selectLastUser();
		 
		 return user;
	 }
	 
	 public boolean isDuplicateEmail(String email) {
		 int count = userRepository.countByEmail(email);
		 
		 // 여기서 중복이 된지 안된지 판단
		 if(count > 0) {
			 return true;
		 } else {
			 return false;
		 }
	 }
}
