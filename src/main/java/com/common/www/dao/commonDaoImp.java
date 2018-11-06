package com.common.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

@Repository
public class commonDaoImp implements commonDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<commonDTO> getStore() {
		return session.selectList("com.common.www.getStore");
	}

	@Override
	public List<commonDTO2> getItem() {
		return session.selectList("com.common.www.getItem");
	}

	@Override
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto) {
		int result = session.insert("insertGoodsFood", goodsDto);

		return goodsDto;
	}

	@Override
	public int insertGoodsCan(commonDTO2 goodsDto) {
		return session.insert("com.common.www.insertGoods", goodsDto);
	}

	@Override
	public int selectTotalPaging() {
		return session.selectOne("com.common.www.selectTotalPaging");
	}

	@Override
	public int deleteGoods(int goodsnumber) {

		return session.delete("com.common.www.deleteGoods", goodsnumber);
	}

	@Override
	public int updateGoods(commonDTO2 goodsDto) {

		return session.update("com.common.www.updateGoods", goodsDto);
	}

	@Override
	public commonDTO2 getItemOne(int goodsnumber) {
		return session.selectOne("com.common.www.getItemOne", goodsnumber);
	}

}
