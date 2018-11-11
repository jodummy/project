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

	// ���� ����Ʈ
	@Override
	public List<commonDTO> getStore() {
		return dao.getStore();
	}

	// ��ǰ ����Ʈ
	@Override
	public List<commonDTO2> getItem() {

		return dao.getItem();
	}

	// ��ǰ �߰�
	@Override
	public commonDTO2 insertGoodsFood(commonDTO2 goodsDto) {
		commonDTO2 result = dao.insertGoodsFood(goodsDto);

		return result;
	}

	// ��������� ��
	@Override
	public int insertGoodsCan(commonDTO2 goodsDto) {

		return dao.insertGoodsCan(goodsDto);
	}

	// ����¡ ó��
	@Override
	public int selectTotalPaging() {

		return dao.selectTotalPaging();
	}

	// ��ǰ ���� ó��
	@Override
	public int deleteGoods(int goodsnumber) {

		return dao.deleteGoods(goodsnumber);
	}

	// ���� ����
	@Override
	public int deleteStore(String storecode) {
		return dao.deleteStore(storecode);
	}

	// ���� ó��
	@Override
	public int updateGoods(commonDTO2 goodsDto) {

		return dao.updateGoods(goodsDto);
	}

	// ��ǰ �ϳ� ��ȸ
	@Override
	public commonDTO2 getItemOne(int goodsnumber) {
		return dao.getItemOne(goodsnumber);
	}

	// ���� �߰�
	@Override
	public commonDTO insertStore(commonDTO storeDto) {
		return dao.insertStore(storeDto);
	}

	// ���� detail
	@Override
	public commonDTO getStoreOne(String storecode) {

		return dao.getStoreOne(storecode);
	}

	// ��� ���
	@Override
	public List<commonDTO3> getEmployee(String storecode) {

		return dao.getEmployee(storecode);
	}

	// ���� ����
	@Override
	public int updateStore(commonDTO storeDto) {
		return dao.updateStore(storeDto);
	}

}
