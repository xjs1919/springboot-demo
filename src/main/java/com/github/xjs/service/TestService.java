package com.github.xjs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.xjs.dao.TestDao;
import com.github.xjs.domain.Test;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年10月18日 下午3:48:24<br/>
 */
@Service
public class TestService {
	
	@Autowired
	TestDao testDao;
	
	public Test getById(int id) {
		return testDao.getById(id);
	}

	public List<Test> getList(int pageNum) {
		int pageSize = 2;
		return testDao.list(pageNum, pageSize);
	}
}
