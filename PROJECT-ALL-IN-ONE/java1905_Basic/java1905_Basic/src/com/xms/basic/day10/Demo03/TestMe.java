package com.xms.basic.day10.Demo03;
/**
 * 测试
 * 
 */
public class TestMe {
	public static void main(String[] args) {
		/*
		 * 2.同一（类型）对象，造型成不同类型时有不同的功能
		 */
		//多态---接口类型的引用指向实现类类型的对象
		Teacher teacher=new Me();
		teacher.teah();
		Police police=new Me();
		police.protect();
		Father father =new Me();
		father.play();
	}

}
