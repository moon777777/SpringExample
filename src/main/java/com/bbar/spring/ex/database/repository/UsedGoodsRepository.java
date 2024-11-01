package com.bbar.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bbar.spring.ex.database.domain.UsedGoods;

// 데이터베이스 관련 처리
// Mybatis Framework
// xml이라는 파일로 구현함 - Mapper
@Mapper
public interface UsedGoodsRepository {

	// used_goods 테이블 모든 해 조회
	public List<UsedGoods> selectUsedGoodsList();
}
