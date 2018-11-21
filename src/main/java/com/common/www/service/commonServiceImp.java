package com.common.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.www.dao.commonDao;
import com.common.www.dao.commonDaoImp;
import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.employeeDTO;

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
	public List<goodsDTO> getItem(goodsDTO goodsDto) {

		return dao.getItem(goodsDto);
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
	public int deleteGoods(goodsDTO goodsDto) {

		return dao.deleteGoods(goodsDto);
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
	public goodsDTO getItemOne(goodsDTO goodsDto) {
		return dao.getItemOne(goodsDto);
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
	public List<employeeDTO> getEmployee(String storeCode) {

		return dao.getEmployee(storeCode);
	}

	// 상점 수정
	@Override
	public int updateStore(storeDTO storeDto) {
		return dao.updateStore(storeDto);
	}

	// 사원 입력
	@Override
	public int insertEmployee(employeeDTO employeeDto) {
		return dao.insertEmployee(employeeDto);
	}

	// 사원 삭제
	@Override
	public int deleteEmployee(String phone) {
		return dao.deleteEmployee(phone);
	}

	// 검색 기능
//	@Override
//	public List<goodsDTO> firstSearchGoods(goodsDTO goodsDto) {
//		return dao.firstSearchGoods(goodsDto);
//	}
//
//	@Override
//	public List<goodsDTO> secondSearchGoods(goodsDTO goodsDto) {
//		return dao.secondSearchGoods(goodsDto);
//	}

}
