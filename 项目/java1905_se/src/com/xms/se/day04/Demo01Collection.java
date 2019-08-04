package com.xms.se.day04;

import java.util.*;

/**
 * 集合的遍历
 * 		1.迭代器遍历
 * 		2.增强型for循环
 * 
 * @author Administrator
 *
 */
public class Demo01Collection {
	public static void method1() {
	/**
	 * 1.迭代器遍历：	Iterartor接口
	 * java希望我们使用统一的方式 遍历集合，因此定义了
	 * 遍历集合的接口，且规定了使用迭代器遍历集合的步骤
	 * 		1.获取迭代器对象
	 * 		2.判断指针是否有元素
	 * 		3.如果有元素，则取该元素
	 * 
	 * 		4.删除----可有可无
	 * 
	 * 
	 */
		Collection c=new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		c.add(1);
		
		//1.获取迭代器对象
		Iterator i=c.iterator();
		//2.判断是否有元素-- 问
		/*
		 * hasNext():判断当前指针是否指向某个元素，如果指向，则返回true,
		 * 如果指针为空
		 * 则返回值为false
		 * 
		 */
		
		while(i.hasNext()) {
			Object o=i.next();
			/*
			 * 在迭代器遍历集合过程中
			 * 如果想要删除某个正在遍历的某个元素
			 * 需要使用迭代器的遍历方法
			 * 
			 */
			System.out.println(o);
		}
		
	}
	
	public static void method2() {
		/**
		 * 2.增强型for循环
		 * 使用增强型for循环遍历集合
		 * java 5.0出现的新特性，该循环不通用于传统
		 * for循环，其功能只用于遍历集合和数组
		 * 语法：
		 * 		for(元素类型 元素名:集合/数组名){
		 * 		遍历内容
		 * 		}
		 * 
		 * 本质是迭代器
		 * for each循环不是新的语法，他的底层是迭代器语法
		 * 因此遍历的过程中不能使用集合删除元素的方法
		 * 
		 * 
		 */
		Collection c=new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		c.add(1);
	}
	
	public static void main(String args[]) {
		method1();
	}
}
//学生类
class Student{
	String name;
	int age;
	
	public Student() {
		
	}
	public Student(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
}
