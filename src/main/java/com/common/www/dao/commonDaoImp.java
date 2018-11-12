package com.common.www.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.commonDTO3;

@Repository
public class commonDaoImp implements commonDao {

	@Autowired
	private SqlSession session;

	// 점포 리스트
	@Override
	public List<storeDTO> getStore() {
		return session.selectList("com.common.www.getStore");
	}

	// 상품 리스트
	@Override
	public List<goodsDTO> getItem() {
		return session.selectList("com.common.www.getItem");
	}

	// 상품 넣기
	@Override
	public goodsDTO insertGoodsFood(goodsDTO goodsDto) {
		int result = session.insert("insertGoodsFood", goodsDto);

		return goodsDto;
	}

	// 상품 넣기 유통기한이 긴
	@Override
	public int insertGoodsCan(goodsDTO goodsDto) {
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
	public int deleteStore(String storeCode) {
		return session.delete("com.common.www.deleteStore", storeCode);
	}

	// 상품 수정 처리
	@Override
	public int updateGoods(goodsDTO goodsDto) {

		return session.update("com.common.www.updateGoods", goodsDto);
	}

	// 상품 하나 조회
	@Override
	public goodsDTO getItemOne(int goodsnumber) {
		return session.selectOne("com.common.www.getItemOne", goodsnumber);
	}

	// 상점 추가
	@Override
	public storeDTO insertStore(storeDTO storeDto) {
		int result = session.insert("insertStore", storeDto);
		return storeDto;
	}

	// 상점 디테일
	@Override
	public storeDTO getStoreOne(String storeCode) {
		return session.selectOne("com.common.www.getStoreOne", storeCode);
	}

	// 사원 출력
	@Override
	public List<commonDTO3> getEmployee(String storeCode) {

		return session.selectList("com.common.www.getEmployee", storeCode);
	}

	@Override
	public int updateStore(storeDTO storeDto) {

		return session.update("com.common.www.updateStore", storeDto);
	}

}
