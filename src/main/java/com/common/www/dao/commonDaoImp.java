package com.common.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.www.dto.commonDTO;
import com.common.www.dto.commonDTO2;

@Repository
public class commonDaoImp implements commonDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<commonDTO> getStore() {
		return session.selectList("com.common.www.getStore");
	}

	@Override
	public List<commonDTO2> getItem() {
		return session.selectList("com.common.www.getItem");
	}

}
