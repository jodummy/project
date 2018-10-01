package com.common.www.dao;

import java.util.List;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

public interface commonDao {
	public List<commonDTO> getStore();

	public List<commonDTO2> getItem();
}
