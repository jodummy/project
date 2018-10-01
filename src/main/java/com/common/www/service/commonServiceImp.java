package com.common.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.www.dao.commonDaoImp;
import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

@Service
public class commonServiceImp implements commonService {
	@Autowired
	private commonDaoImp dao;

	@Override
	public List<commonDTO> getStore() {
		return dao.getStore();
	}

	@Override
	public List<commonDTO2> getItem() {

		return dao.getItem();
	}

}
