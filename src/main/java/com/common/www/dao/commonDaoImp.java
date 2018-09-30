package com.common.www.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.common.www.dto.commonDTO;

@Repository
public class commonDaoImp implements commonDao {

	@Autowired
	private SqlSession session;

	@Override
	public List<commonDTO> getstore() {
		return session.selectList("com.common.www.getstore");
	}

}
