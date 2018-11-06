package com.common.www.dao;

import java.util.List;
import java.util.Map;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

public interface commonDao {
	// 점포 리스트
	public List<commonDTO> getStore();

	// 상품 리스트
	public List<commonDTO2> getItem();

	// 상품 넣기
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto);

	// 상품 넣기 유통기한이 긴
	public int insertGoodsCan(commonDTO2 goodsDto);

	// 페이징 처리
	public int selectTotalPaging();

	// 상품 삭제
	public int deleteGoods(int goodsnumber);

	// 상품 수정 처리
	public int updateGoods(commonDTO2 goodsDto);

	// 상품 하나 조회
	public commonDTO2 getItemOne(int goodsnumber);
}
