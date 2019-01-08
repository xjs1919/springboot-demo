package com.github.xjs.dao;

import java.util.Properties;

import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.pagehelper.PageInterceptor;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年10月18日 下午4:48:30<br/>
 */
@Configuration
public class MybatisConfig {
	
	@Bean 
	public Interceptor getInterceptor(){ 
		PageInterceptor interceptor = new PageInterceptor();
		Properties properties = new Properties();
		properties.put("helperDialect", "mysql");
		properties.put("reasonable", "true");
		properties.put("supportMethodsArguments", "true");
		properties.put("params", "pageNum=pageNum;pageSize=pageSize;");;
		interceptor.setProperties(properties);
		return interceptor;
	}
	
}
