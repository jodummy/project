package com.common.www.service;

import java.util.List;
import java.util.Map;

import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.employeeDTO;

public interface commonService {
	// 점포 리스트
	public List<storeDTO> getStore();

	// 상품 하나 조회
	public goodsDTO getItemOne(goodsDTO goodsDto);

	// 상품 리스트
	public List<goodsDTO> getItem(goodsDTO goodsDto);

	// 상품 추가
	public goodsDTO insertGoodsFood(goodsDTO goodsDto);

	// 유통기한이 긴
	public int insertGoodsCan(goodsDTO goodsDto);

	// 페이징 처리
	public int selectTotalPaging();

	// 상품 삭제 처리
	public int deleteGoods(goodsDTO goodsDto);

	// 상점 삭제
	public int deleteStore(String storeCode);

	// 수정 처리
	public int updateGoods(goodsDTO goodsDto);

	// 상점 추가
	public storeDTO insertStore(storeDTO storeDto);

	// 상점 detail
	public storeDTO getStoreOne(String storeCode);

	// 사원 리스트
	public List<employeeDTO> getEmployee(String storeCode);

	// 상점 수정
	public int updateStore(storeDTO storeDto);

	// 사원 추가
	public int insertEmployee(employeeDTO employeeDto);

	// 사원 삭제
	public int deleteEmployee(String phone);

	// 검색 기능
//	public List<goodsDTO> firstSearchGoods(goodsDTO goodsDto);
//	public List<goodsDTO> secondSearchGoods(goodsDTO goodsDto);

}
