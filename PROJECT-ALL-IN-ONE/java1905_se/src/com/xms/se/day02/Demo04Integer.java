package com.xms.se.day02;
/**
 * 包装类：针对基本数据类型，将基本数据类型包装成引用数据类型对应的数据包装成对象
 * 
 * 
 * @author Administrator
 *
 */
public class Demo04Integer {
	public  static void main(String args []) {
		/**
		 * 装箱：将基本数据类型转成引用数据类型
		 * 拆箱：将引用数据类型转成基本数据类型
		 */
		
		
		
		
		int i=23;//基本数据类型 i就是基本变量
		/*
		 * valueOf(基本类型 变量)
		 * 将基本数据类型包装成引用数据类型的方法
		 * 返回值为对应基本数据类型的包装类
		 * 语法：包装类.valueOf(基本类型 变量)
		 */
		Integer i1=Integer.valueOf(i);
		//构造方法 
		Integer i2=new Integer(23);
		
		
		int ii=i2.intValue();
		
		/**
		 * 自动装箱：将基本数据类型自动装箱成引用数据类型
		 * 自动拆箱：将引用数据类型自动拆箱成基本数据类型
		 */
		
	}
}
