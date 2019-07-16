package com.xms.se.day02;

import java.util.Scanner;

/**
 * 正则表达式：本身不属于java，借鉴使用
 * ---理解为规则
 * ---主要是用于验证字符串的格式
 * ---matches(String regex):全匹配
 * 		判断当前字符串对象是否满足指定的正则格式
 * 		返回值为布尔类型
 * 		--格式符合：true
 * 		--格式不符合：false
 * 
 * 
 * @author Administrator
 *
 */
public class Demo03Zz {
	public static void method1() {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入字符串：");
		String line=sc.nextLine();
		String regex="[a-z&&^bz]";
		if(line.matches(regex)) {
			System.out.println("格式正确");
		}else {
			System.out.println("格式不正确"); 
		}
	}
	
	public static void method3() {
		//电话号码 1加上是个数字
		String regex1="[1]\\d{10}";
		String s1="15555127212";
		System.out.println(s1.matches(regex1));
		System.out.println("---------------------------------");
		//身份证号码
		//前六位数字 年份 月份 日 四位数字
		String regex2="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
		String regex3="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
		String regex4="\\w{4,}@\\w{2,5}(.com|.cn";
	}
	
	public static void method4() {
		/*
		 * replaceAll(String regex,String str):
		 * 将当前字符串中以正则表达式regex表示的字符串替换成str
		 * 返回值为被替换后的字符串对象
		 */
		//将所有数字替换成！
		String str="aaa12345bbb4567cccc1dddd";
		String regex="\\d";
		String s1=str.replaceAll(regex,"!");
		System.out.println(s1);
		String regex1="\\d+";
		String s2=str.replaceAll(regex1, "!");
		System.out.println(s2);
		System.out.println("-----------------------------------");
		/*
		 * spilt(String regex):
		 * 将当字符串对象以指定的正则表达式分割
		 * 返回值为字符串数组
		 */
		//[aaa,bbb,cccc,dddd]
		String regex2="\\d+";

	}
	public static void main(String args[]) {
//		method1();
//		method3();
		method4();
	}
}
