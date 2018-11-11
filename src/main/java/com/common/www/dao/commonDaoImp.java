package com.common.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;
import com.common.www.dto.commonDTO3;

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

	// 상품 넣기
	@Override
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto) {
		int result = session.insert("insertGoodsFood", goodsDto);

		return goodsDto;
	}

	// 상품 넣기 유통기한이 긴
	@Override
	public int insertGoodsCan(commonDTO2 goodsDto) {
		return session.insert("com.common.www.insertGoods", goodsDto);
	}

	// 페이징 처리
	@Override
	public int selectTotalPaging() {
		return session.selectOne("com.common.www.selectTotalPaging");
	}

	// 상품 삭제
	@Override
	public int deleteGoods(int goodsnumber) {

		return session.delete("com.common.www.deleteGoods", goodsnumber);
	}

	// 상점 삭제
	@Override
	public int deleteStore(String storecode) {
		return session.delete("com.common.www.deleteStore", storecode);
	}

	// 상품 수정 처리
	@Override
	public int updateGoods(commonDTO2 goodsDto) {

		return session.update("com.common.www.updateGoods", goodsDto);
	}

	// 상품 하나 조회
	@Override
	public commonDTO2 getItemOne(int goodsnumber) {
		return session.selectOne("com.common.www.getItemOne", goodsnumber);
	}

	// 상점 추가
	@Override
	public commonDTO insertStore(commonDTO storeDto) {
		int result = session.insert("insertStore", storeDto);
		return storeDto;
	}

	// 상점 디테일
	@Override
	public commonDTO getStoreOne(String storecode) {
		return session.selectOne("com.common.www.getStoreOne", storecode);
	}

	// 사원 출력
	@Override
	public List<commonDTO3> getEmployee(String storecode) {

		return session.selectList("com.common.www.getEmployee", storecode);
	}

	@Override
	public int updateStore(commonDTO storeDto) {

		return session.update("com.common.www.updateStore", storeDto);
	}

}
