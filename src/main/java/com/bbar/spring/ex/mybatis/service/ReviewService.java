package com.bbar.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbar.spring.ex.mybatis.domain.Review;
import com.bbar.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;

	// 전달받은 id와 대응되는 리뷰정보 얻어오기
	public Review getReview(int id) {
		// new_review 테이블의 id가 전달받은 id와 일치하는 값
		
		Review review = reviewRepository.selectReview(id);
		
		return review;
	}
	
	// 전달받은 리뷰 정보를 기반으로 리뷰 저장
	public int addReview(
			int storeId
			, String menu
			, String userName
			, double point
			, String review) {
		
		// 전달받은 리뷰내용으로 new_review 테이블에 insert
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		
		return count;
		
	}
	
	// 전달 받은 REview 객체를 통해 저장
	public int addReviewByObject(Review review) {
		
		// 전달받은 Review 객체로 new_review 에 insert
		int count = reviewRepository.insertReviewByObject(review);
		
		return count;
	}
}
