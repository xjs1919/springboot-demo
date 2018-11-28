package com.github.xjs.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.xjs.domain.Test;
import com.github.xjs.service.TestService;
import com.github.xjs.service.redis.TestKey;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.github.xjs.service.redis.RedisService;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年10月18日 上午9:53:58<br/>
 */
@Api(tags = "demo演示")
@RestController
@RequestMapping("/demo")
public class DemoController {
	
	@Autowired
	TestService testService;
	
	@Autowired
	RedisService redisService;
		
	@ApiOperation(value="返回json")
	@RequestMapping(value="/json", method=RequestMethod.GET)
	public String json() {
		return "hello";
	}
	
	@ApiOperation(value="访问DB")
	@RequestMapping(value="/db/get", method=RequestMethod.GET)
	public Test dbGet() {
		return testService.getById(1);
	}
	
	@ApiOperation(value="DB分页查询")
	@RequestMapping(value="/db/page", method=RequestMethod.GET)
	public List<Test> dbPage(@RequestParam("page") int page) {
		return testService.getList(page);
	}
	
	@ApiOperation(value="访问redis")
	@RequestMapping(value="/redis/get", method=RequestMethod.GET)
	public String redisGet() {
		redisService.set(TestKey.getById, "1", new Test(1, "xjs", 30, new Date()));
		Test value3 = redisService.get(TestKey.getById, "1", Test.class);
		return value3.toString();
	}

}
