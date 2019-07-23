package com.xms.se.day01;
/**
 * char a='a';
 * char b='b';
 * 
 * char[] arr=new char[] {a,b}; 
 * 
 * 字符串构造方法：
 * 1.public String() 无参构造方法
 * 	String str=new String();<===>String str="";
 * 
 * 2.public String(byte[] byte):
 * 将字节数组转成字符串对象
 * 
 * 3.public String(byte[] byte,int index,int length):
 * 将指定的字节数组，从指定的下标开始转成字符串，连续length个字节
 * 
 * 4.public String(char[] ch):
 * 将指定的字符数组转成字符串对象
 * 
 * 5.public String(char[] ch,int index,int length):
 * 将指定的字符数组，从指定的下标开始转成字符串，连续length个字节
 * 
 * 6.public String(String str):
 * 将字符串常量转成字符串对象
 * 
 * 
 * 
 * String:字符串类型--引用数据类型
 * --底层：字符数组
 * 1.字符串字面量“abc”，可以看作一个字符串对象
 * 2.字符串字面量是常量，一旦定义，不可更改
 * 
 * 
 * @author Administrator
 *
 */
public class Demo02String {
	public static void method1() {
		//创建字符串对象
		String str=new String();
		//创建字符串对象--字面量 唯一的可以使用字面量方式创建对象的引用数据类型
		String str1="";
	}
	
	public static void method2() {
		//将字节数组转成字符串对象
		byte[] by=new byte[] {97,98,99,100};
		String str1=new String(by);
		System.out.println(str1);
		String str2=new String(by,1,3);
		System.out.println(str2);
		
		char[] ch=new char[] {'a','b','c','d'};
		String str3=new String(ch);
		System.out.println(str3);
		String str4=new String(ch,1,3);
		System.out.println(str4);
	}
	
	public static void method3() {
		String str1="abc";
		String str2="abc";
		String str3=new String("abc");
		String str4=new String("abc");
		/*
		 * ==和equals的区别（都是boolean类型结果）
		 * 		1.==：
		 * 			基本类型：比较值的大小是否相等
		 * 			引用类型：比较地址值是是否相等
		 * 		2.equals():
		 * 			String类
		 * 			已经重写equals（）方法：只要两个字符串对象的内容“相等”，
		 * 			就返回一个true，否则返回false
		 * 		
		 */
		/*
		 * 常量池：节省空间资源
		 * 
		 * 使用字面量创建对象时，会优先在堆中的字符串常量池中寻找与该对象内容是否“一样”
		 * 如果一样，则将字符串在常量池的地址直接赋值给需要创建该数据的变量，如果没有，
		 * 则在字符串常量池创建该数据，并将地址赋值给该数据
		 * 
		 * new关键字创建字符串对象，是一个强制性操作，会强制在堆内存中开辟空间存储数据
		 * 		1.常量池中没有该数据，则会在常量池中和在常量池之外的堆内存中创建该数据
		 * 		且引用变量会指向new关键字开辟的内存地址
		 * 		2.常量池中有该数据，则直接在堆内存中开辟空间存储该数据
		 */
		
		
	}
	
	public static void method4() {
		String str1="";//有地址 值是空的
		String str2=" ";//有地址 值是空格
		String str3=null;//没有地址
		System.out.println(str1.equals(""));//true
		System.out.println(str2.equals(""));//false
		System.out.println(str3.equals(""));//抛出异常
		/*
		 * NullPointerException:空指针异常
		 * 
		 */		
	}
	
	public static void method5() {
		/*
		 * 编辑器特性：当一个表达时两边都是字面量时，编辑器会直接将表达时结果生成在该位置
		 * 目的是减少运算开销
		 */
		String s1="1234";//一个对象
		String s2="123"+"4";//一个对象“1234”
		String s3="123";//一个对象
		String s4=s3+"4";//两个对象
		
	}
	public static void main(String args[]) {
		method2();
		method3();
		method4();
	}

}
