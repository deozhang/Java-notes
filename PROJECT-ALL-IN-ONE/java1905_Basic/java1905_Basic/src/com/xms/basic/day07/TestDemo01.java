package com.xms.basic.day07;
/**
 * 测试类
 * @author Administrator
 *
 */
public class TestDemo01 {
	public static void main(String[] args) {
//		String name="张三";
//		char sex='男';
//		int age=18;
//		long id=340406199908062418l;
//		Demo01.printInformation(name, sex, age, id);
//		System.out.println("--1-------------------------------------");
//		//用多个数据的 集合描述一个整体---人类
//		//如下没有对数据进行统一的封装
//		String name1="11";
//		char sex1='?';
//		int age1=-20;
//		long id1=2;
//		Demo01.printInformation(name1, sex1, age1, id1);
		
		//创建对象---实例化
		/*
		 * 基本数据类型---基本类型变量
		 * 引用数据类型---引用变量
		 * 
		 * new ---强制操作，一旦出现new关键字，就会在内存中开辟对应的
		 * 				存储空间
		 */
		int a=12;
		Human h=new Human();
		/*
		 * 取值和赋值通过引用变量
		 */
		//成员变量的初始化---赋值
		h.name="张三";
		h.sex='男';
		h.age=18;
		h.id=340406199908062418l;
		String name1=h.name;
		//取值
		System.out.println(name1);
//		Demo01.printInformation(h);
		
		//调用成员方法
		h.printInformation();
		
		
	}
}


































