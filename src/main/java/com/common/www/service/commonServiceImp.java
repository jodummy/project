package com.common.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.www.dao.commonDao;
import com.common.www.dao.commonDaoImp;
import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.commonDTO3;

@Service
public class commonServiceImp implements commonService {
	@Autowired
	private commonDao dao;

	// 점포 리스트
	@Override
	public List<storeDTO> getStore() {
		return dao.getStore();
	}

	// 상품 리스트
	@Override
	public List<goodsDTO> getItem() {

		return dao.getItem();
	}

	// 상품 추가
	@Override
	public goodsDTO insertGoodsFood(goodsDTO goodsDto) {
		goodsDTO result = dao.insertGoodsFood(goodsDto);

		return result;
	}

	// 유통기한이 긴
	@Override
	public int insertGoodsCan(goodsDTO goodsDto) {

		return dao.insertGoodsCan(goodsDto);
	}

	// 페이징 처리
	@Override
	public int selectTotalPaging() {

		return dao.selectTotalPaging();
	}

	// 상품 삭제 처리
	@Override
	public int deleteGoods(int goodsSumber) {

		return dao.deleteGoods(goodsSumber);
	}

	// 상점 삭제
	@Override
	public int deleteStore(String storeCode) {
		return dao.deleteStore(storeCode);
	}

	// 수정 처리
	@Override
	public int updateGoods(goodsDTO goodsDto) {

		return dao.updateGoods(goodsDto);
	}

	// 상품 하나 조회
	@Override
	public goodsDTO getItemOne(int goodsSumber) {
		return dao.getItemOne(goodsSumber);
	}

	// 상점 추가
	@Override
	public storeDTO insertStore(storeDTO storeDto) {
		return dao.insertStore(storeDto);
	}

	// 상점 detail
	@Override
	public storeDTO getStoreOne(String storeCode) {

		return dao.getStoreOne(storeCode);
	}

	// 사원 출력
	@Override
	public List<commonDTO3> getEmployee(String storeCode) {

		return dao.getEmployee(storeCode);
	}

	// 상점 수정
	@Override
	public int updateStore(storeDTO storeDto) {
		return dao.updateStore(storeDto);
	}

}
