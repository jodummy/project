package com.common.www.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.employeeDTO;

@Repository
public class commonDaoImp implements commonDao {

	@Autowired
	private SqlSession session;

	// 점포 리스트
	@Override
	public List<storeDTO> getStore() {
		return session.selectList("com.common.www.getStore");
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
	public int deleteGoods(goodsDTO goodsDto) {

		return session.delete("com.common.www.deleteGoods", goodsDto);
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
	public goodsDTO getItemOne(goodsDTO goodsDto) {
		return session.selectOne("com.common.www.getItemOne", goodsDto);
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
	public List<employeeDTO> getEmployee(String storeCode) {

		return session.selectList("com.common.www.getEmployee", storeCode);
	}

	// 상점 수정
	@Override
	public int updateStore(storeDTO storeDto) {

		return session.update("com.common.www.updateStore", storeDto);
	}

	// 사원 추가
	@Override
	public int insertEmployee(employeeDTO employeeDto) {
		int result = session.insert("insertEmployee", employeeDto);
		return result;
	}

	// 사원 삭제
	@Override
	public int deleteEmployee(String phone) {
		return session.delete("com.common.www.deleteEmployee", phone);
	}

	@Override
	public List<goodsDTO> getListGoods(goodsDTO goodsDto) {
		return session.selectList("com.common.www.getListGoods", goodsDto);
	}

//	@Override
//	public List<goodsDTO> firstSearchGoods(goodsDTO goodsDto) {
//		return session.selectList("com.common.www.firstSearchGoods", goodsDto);
//	}
//	@Override
//	public List<goodsDTO> secondSearchGoods(goodsDTO goodsDto) {
//		return session.selectList("com.common.www.secondSearchGoods", goodsDto);
//	}

}
