package com.common.www.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.common.www.dao.commonDao;
import com.common.www.dao.commonDaoImp;
import com.common.www.dto.storeDTO;
import com.common.www.dto.goodsDTO;
import com.common.www.dto.employeeDTO;

@Service
public class commonServiceImp implements commonService {
	@Autowired
	private commonDao dao;

	// ���� ����Ʈ
	@Override
	public List<storeDTO> getStore() {
		return dao.getStore();
	}

	// ��ǰ �߰�
	@Override
	public goodsDTO insertGoodsFood(goodsDTO goodsDto) {
		goodsDTO result = dao.insertGoodsFood(goodsDto);

		return result;
	}

	// ��������� ��
	@Override
	public int insertGoodsCan(goodsDTO goodsDto) {

		return dao.insertGoodsCan(goodsDto);
	}

	// ����¡ ó��
	@Override
	public int selectTotalPaging() {

		return dao.selectTotalPaging();
	}

	// ��ǰ ���� ó��
	@Override
	public int deleteGoods(goodsDTO goodsDto) {

		return dao.deleteGoods(goodsDto);
	}

	// ���� ����
	@Override
	public int deleteStore(String storeCode) {
		return dao.deleteStore(storeCode);
	}

	// ���� ó��
	@Override
	public int updateGoods(goodsDTO goodsDto) {

		return dao.updateGoods(goodsDto);
	}

	// ��ǰ �ϳ� ��ȸ
	@Override
	public goodsDTO getItemOne(goodsDTO goodsDto) {
		return dao.getItemOne(goodsDto);
	}

	// ���� �߰�
	@Override
	public storeDTO insertStore(storeDTO storeDto) {
		return dao.insertStore(storeDto);
	}

	// ���� detail
	@Override
	public storeDTO getStoreOne(String storeCode) {

		return dao.getStoreOne(storeCode);
	}

	// ��� ���
	@Override
	public List<employeeDTO> getEmployee(String storeCode) {

		return dao.getEmployee(storeCode);
	}

	// ���� ����
	@Override
	public int updateStore(storeDTO storeDto) {
		return dao.updateStore(storeDto);
	}

	// ��� �Է�
	@Override
	public int insertEmployee(employeeDTO employeeDto) {
		return dao.insertEmployee(employeeDto);
	}

	// ��� ����
	@Override
	public int deleteEmployee(String phone) {
		return dao.deleteEmployee(phone);
	}

	@Override
	public List<goodsDTO> getListGoods(goodsDTO goodsDto) {

		return dao.getListGoods(goodsDto);
	}

	//Ʈ������ �κ�
	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean updateIncomeTotal(goodsDTO goodsDto) {
		boolean isc = false;
		if (dao.updateBuy(goodsDto) && dao.updateStoreIncome(goodsDto)) {
			isc = true;
		}
		return false;
	}
}
