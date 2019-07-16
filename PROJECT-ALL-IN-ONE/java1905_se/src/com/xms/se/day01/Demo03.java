package com.xms.se.day01;
/**
 * 介绍字符串常用的方法
 * @author Administrator
 *
 */
public class Demo03 {
	public static void method1() {
		String str="0123456789";
		/*
		 * length():获取当前字符串对象的长度（字符个数）
		 * 返回值为整数类型（int）
		 */
		int len=str.length();
		System.out.println(len);
	}
	
	public static void method2() {
		/**
		 * 字符串的底层是字符数组：字符串的下标从0开始，到length-1结束
		 * 字符串的方法，参数如果是下标：前包括后不包括eg: [0,100)
		 */
		/*
		 * indexOf(String str):
		 * 检索当前字符串中指定字符串的位置
		 * 返回值为整数类型（int）,是该字符串的下标位置
		 * 
		 * 1.整体匹配，返回值是从左到右最先匹配到的字符串下标
		 * 2.如果没有匹配到指定字符串，则返回值为-1;
		 */
		
		String str="good good study,day day up";
		int index1=str.indexOf("day");
		System.out.println(index1);
		int index2=str.indexOf("hello");
		System.out.println(index2);
		System.out.println("--------------------------------------------------");
		/*
		 * indexOf(String str,int index):
		 * 在当前字符串从下标为index位置开始检索str
		 * 返回值为int类型的字符串下标
		 */
		int index4=str.indexOf("d",4);
		System.out.println(index4);
		
		/*
		 * lastIndexOf(String str):
		 * 检索指定字符串最后一次出现的位置
		 * 返回值为int类型，为对应字符串的下标
		 */
		int index5=str.lastIndexOf("good");
		System.out.println(index5);
		
		int index6=str.indexOf("good",str.indexOf("good")+1);//方法嵌套使用
		System.out.println(index6);
		
	}
	public static void main(String args[]) {
		method1();
		method2();
	}
}
