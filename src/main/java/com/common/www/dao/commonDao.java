package com.common.www.dao;

import java.util.List;
import java.util.Map;

import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.commonDTO3;

public interface commonDao {
	// 점포 리스트
	public List<storeDTO> getStore();

	// 상품 리스트
	public List<goodsDTO> getItem();

	// 상품 넣기
	public goodsDTO insertGoodsFood(goodsDTO goodsDto);

	// 상품 넣기 유통기한이 긴
	public int insertGoodsCan(goodsDTO goodsDto);

	// 페이징 처리
	public int selectTotalPaging();

	// 상품 삭제
	public int deleteGoods(int goodsSumber);

	// 상품 수정 처리
	public int updateGoods(goodsDTO goodsDto);

	// 상품 하나 조회
	public goodsDTO getItemOne(int goodsSumber);

	// 상점 추가
	public storeDTO insertStore(storeDTO storeDto);

	// 상점 삭제
	public int deleteStore(String storeCode);

	// 상점 detail
	public storeDTO getStoreOne(String storeCode);

	// 사원 출력
	public List<commonDTO3> getEmployee(String storeCode);

	// 상점 수정
	public int updateStore(storeDTO storeDto);

}
