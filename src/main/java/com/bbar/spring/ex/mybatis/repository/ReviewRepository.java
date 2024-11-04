package com.bbar.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.bbar.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// 전달된 id와 일치하는 리뷰 행 조회
	public Review selectReview(@Param("id") int id);
}
