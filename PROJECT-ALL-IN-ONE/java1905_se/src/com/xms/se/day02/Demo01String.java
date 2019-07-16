package com.xms.se.day02;

import java.util.Scanner;

public class Demo01String {
	public static void method1() {
		/*
		 * subString(int start,int end):
		 * 截取字符串[start,end),返回值为截取的字符串
		 */
		String str="0123456789";
		String s=str.substring(1,7);
		System.out.println(s);
		/*
		 * subString(int index);
		 * 截取字符串，从index位置开始截取index(index)位置之后的字符串
		 * 返回值为对应的字符串
		 */
		String s1=str.substring(4);
		System.out.println(s1);
		/*
		 * 一般截取域名
		 * www.baidu.com
		 * --baidu
		 */
		String str1="www.baidu.com";
		String ss=str1.substring(str1.indexOf(".")+1,str1.lastIndexOf("."));
		System.out.println(ss);
	}
	
	public static void method2() {
		/*
		 * trim():去除字符串两端空白
		 * ---不能去除中间的空白
		 */
		String str=" 中国 人民 ";
		System.out.println(str);
		String s=str.trim();
		System.out.println(s);
	}
	
	public static void method3() {
		/*
		 * charAt(int index)：
		 * 返回值为对应位置上的字符
		 */
		String str="hello";
		char s=str.charAt(2);
		System.out.println(s);
	}
	
	public static void method4() {
		/*
		 * startsWith(String str):是否以给定的字符串开头
		 * endsWith(String str):是否以给定的字符串结尾
		 * 返回值为boolean类型
		 * 以指定字符串---true
		 * 不以指定字符串---false
		 */
		//判断上传的文件是否以指定的文件格式结尾.txt
		System.out.println("请上传文件：");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		if(str.endsWith("txt")) {
			System.out.println("文件格式正确");
		}else {
			System.out.println("文件格式错误");
		}
	}
	
	public static void method5() {
		/*
		 * toUpperCase():将字母字符串转成大写
		 * toLowerCase():将字母字符串转成小写
		 * 返回值为转换后的字符串对象 
		 */
		String str1="abc";
		String str2="ABC";
		String s1=str1.toUpperCase();
		String s2=str2.toLowerCase();
		System.out.println("s1:"+s1);
		System.out.println("s2:"+s2);
		/*
		 * equalsIgnoreCase():
		 * 不区分字母大小写比较字符串
		 * 返回值为布尔类型
		 */
		if(str1.equals(str2)) {
			System.out.println("区分大小写比较");
		}else {
			System.out.println("不区分大小写比较");
		}
	}
	
	public static void method6() {
		/*
		 * String.valueOf(基本类型 i)
		 * 将基本类型转成字符串类型
		 * 返回值为字符串类型
		 */
		int i=23;
		System.out.println(i+2);
		String s=String.valueOf(i);
		System.out.println(s+2);
	}
	public static void main(String args[]) {
		method1();
		method2();
		method3();
		method4();
		method5();
		method6();
	}
}
