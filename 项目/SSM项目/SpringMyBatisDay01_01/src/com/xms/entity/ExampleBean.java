package com.xms.entity;

public class ExampleBean {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public ExampleBean() {
		System.out.println("实例化ExampleBean:"+this);
	}
	
	//作为初始化回调方法
	public void init() {
		id = 5;
		System.out.println("初始化ExampleBean");
	}
	
	//销毁的回调方法
	public void destroy(){
		System.out.println("销毁ExampleBean");
	}
}
