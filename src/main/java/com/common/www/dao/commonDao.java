package com.common.www.dao;

import java.util.List;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

public interface commonDao {
	// 점포 리스트
	public List<commonDTO> getStore();

	// 상품 리스트
	public List<commonDTO2> getItem();

	// 상품 식품 insert
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto);

	// 그외 식품 리스트
	public int insertGoodsCan(commonDTO2 goodsDto);

	public int selectTotalPaging();
}
