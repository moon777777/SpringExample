package com.bbar.spring.ex.mvc.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bbar.spring.ex.mvc.domain.User;

@Mapper
public interface UserRepository {
	
	public int insertUser(
			@Param("name") String name
			,@Param("birthday") String birthday
			,@Param("email") String email
			,@Param("introduce") String introduce);
	
	public int insertUserByObject(User user);
	
	public User selectLastUser();
	
	public int countByEmail(@Param("email")String email);
}
