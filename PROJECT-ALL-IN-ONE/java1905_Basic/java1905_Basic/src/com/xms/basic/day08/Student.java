package com.xms.basic.day08;
/**
 * JavaBean
 * 
 * 
 * 权限修饰符：
 * public :公共的，公开的 
 * private:私有的
 * @author Administrator
 *
 */
public  class Student {
	//成员变量--数据---私有
	private String name;
	private int age;
	private int id;
	
	//成员方法---操作数据---公开
	//赋值--set
	public void setName(String name) {
		this.name=name;
	}
	//取值--get
	public String getName() {
		
		return name;
	}
	

}



















