package com.common.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

@Repository
public class commonDaoImp implements commonDao {

	@Autowired
	private SqlSession session;

	// 점포 리스트
	@Override
	public List<commonDTO> getStore() {
		return session.selectList("com.common.www.getStore");
	}

	// 상품 리스트
	@Override
	public List<commonDTO2> getItem() {
		return session.selectList("com.common.www.getItem");
	}

	// 식품 insert
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto) {
		int result = session.insert("insertGoodsFood", goodsDto);

		return goodsDto;
	}

	// 그 이외 전부 (먹을 수 있는)
	public int insertGoodsCan(commonDTO2 goodsDto) {
		return session.insert("com.common.www.insertGoods", goodsDto);
	}

	@Override
	public int selectTotalPaging() {
		return session.selectOne("com.common.www.selectTotalPaging");
	}

}
