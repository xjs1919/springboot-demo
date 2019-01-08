package com.github.xjs.domain;

import java.util.Date;

/**
 * @author 605162215@qq.com
 *
 * @date 2018年10月18日 上午10:21:01<br/>
 */
public class Test {
	private int id;
	private String name;
	private int age;
	private Date createDate;
	
	public Test() {}
	
	public Test(int id, String name, int age, Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.createDate = createDate;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", age=" + age + ", createDate=" + createDate + "]";
	}
	
}
