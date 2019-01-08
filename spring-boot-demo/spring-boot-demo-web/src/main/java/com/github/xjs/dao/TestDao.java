package com.github.xjs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.github.xjs.domain.Test;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年10月18日 上午9:56:50<br/>
 */
@Mapper
public interface TestDao {
	
	public Test getById(@Param("id")int id);

	public List<Test> list(@Param("pageNum")int pageNum, @Param("pageSize")int pageSize);
}
