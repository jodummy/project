package com.common.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.www.dao.commonDao;
import com.common.www.dao.commonDaoImp;
import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;
import com.common.www.dto.commonDTO3;

@Service
public class commonServiceImp implements commonService {
	@Autowired
	private commonDao dao;

	// 점포 리스트
	@Override
	public List<commonDTO> getStore() {
		return dao.getStore();
	}

	// 상품 리스트
	@Override
	public List<commonDTO2> getItem() {

		return dao.getItem();
	}

	// 상품 추가
	@Override
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto) {
		commonDTO2 result = dao.insertGoodsFood(goodsDto);

		return result;
	}

	// 유통기한이 긴
	@Override
	public int insertGoodsCan(commonDTO2 goodsDto) {

		return dao.insertGoodsCan(goodsDto);
	}

	// 페이징 처리
	@Override
	public int selectTotalPaging() {

		return dao.selectTotalPaging();
	}

	// 상품 삭제 처리
	@Override
	public int deleteGoods(int goodsnumber) {

		return dao.deleteGoods(goodsnumber);
	}

	// 상점 삭제
	@Override
	public int deleteStore(String storecode) {
		return dao.deleteStore(storecode);
	}

	// 수정 처리
	@Override
	public int updateGoods(commonDTO2 goodsDto) {

		return dao.updateGoods(goodsDto);
	}

	// 상품 하나 조회
	@Override
	public commonDTO2 getItemOne(int goodsnumber) {
		return dao.getItemOne(goodsnumber);
	}

	// 상점 추가
	@Override
	public commonDTO insertStore(commonDTO storeDto) {
		return dao.insertStore(storeDto);
	}

	// 상점 detail
	@Override
	public commonDTO getStoreOne(String storecode) {

		return dao.getStoreOne(storecode);
	}

	// 사원 출력
	@Override
	public List<commonDTO3> getEmployee(String storecode) {

		return dao.getEmployee(storecode);
	}

	// 상점 수정
	@Override
	public int updateStore(commonDTO storeDto) {
		return dao.updateStore(storeDto);
	}

}
