package com.common.www.service;

import java.util.List;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

public interface commonService {
	// 점포 지점
	public List<commonDTO> getStore();

	// 상품 리스트
	public List<commonDTO2> getItem();

	// 상품 넣기(식품)
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto);

	// 상품 넣기(그 이외)
	public int insertGoodsCan(commonDTO2 goodsDto);

	// goods 상품 갯수
	public int selectTotalPaging();
}
