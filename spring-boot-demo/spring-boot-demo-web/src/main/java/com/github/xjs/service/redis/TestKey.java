package com.github.xjs.service.redis;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年10月18日 下午4:37:24<br/>
 */
public class TestKey extends AbstractKey{

	public TestKey(String value) {
		super(value);
	}
	
	public static TestKey getById = new TestKey("id");
	
}
