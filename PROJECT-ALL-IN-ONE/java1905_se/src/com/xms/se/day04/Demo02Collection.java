package com.xms.se.day04;

import java.util.*;

/**
 * 一般使用集合--使用动态改变空间大小的特性
 *	而不会用到类型多样的特性--因此引出了集合泛型
 * 集合泛型 jdk1.5之后开始支持
 * 主要是限制集合元素的类型
 * 方便后期对元素进行统一操作
 * 
 * 
 * 所有集合都支持泛型
 * 迭代器也支持泛型
 * 
 * 
 * @author Administrator
 *
 */
public class Demo02Collection {
	public static void method1() {
		//给对应的集合添加泛型---<引用数据类型>
		//注意前后泛型类型一致
		Collection<Integer> c=new ArrayList<Integer>();
//		c.add("a");
		c.add(1);
//		c.add(new Student("zs",18));
		//1.获取迭代器对象
		//迭代器泛型通常与要遍历的集合泛型一致
		Iterator<Integer> i=c.iterator();
		//2.问
		while(i.hasNext()) {
			//3.取
			Integer o=i.next();
			//
//			if(o instanceof Student) {
//				Student s=(Student)o;
//				
//				System.out.println(s.name);
//			}
			System.out.println(o);
		}

	}
	
	public static void main(String args[]) {
		method1();
	}
}








































