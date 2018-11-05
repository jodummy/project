package com.common.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.www.dao.commonDao;
import com.common.www.dao.commonDaoImp;
import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

@Service
public class commonServiceImp implements commonService {
	@Autowired
	private commonDao dao;

	@Override
	public List<commonDTO> getStore() {
		return dao.getStore();
	}

	@Override
	public List<commonDTO2> getItem() {

		return dao.getItem();
	}

	@Override
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto) {
		commonDTO2 result = dao.insertGoodsFood(goodsDto);

		return result;
	}

	@Override
	public int insertGoodsCan(commonDTO2 goodsDto) {

		return dao.insertGoodsCan(goodsDto);
	}

	@Override
	public int selectTotalPaging() {

		return dao.selectTotalPaging();
	}

	@Override
	public int deleteGoods(int goodsnumber) {

		return dao.deleteGoods(goodsnumber);
	}

}
