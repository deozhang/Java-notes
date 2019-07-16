package com.xms.basic.day03;
/**
 * 演示条件运算（三目运算）：
 * 		语法结构：
 * 				表达式（布尔类型表达式）？表达式1：表达式2；
 * 		执行流程:
 * 				首先判断布尔类型表达式，如果布尔类型表达式为
 * 				true,则执行表达式1，如果布尔类型表达式为false
 * 				则执行表达式2，执行完后，程序结束
 * 		注意：
 * 				1.表达式1和表达式2可以具体值，同时需要这两个表
 * 					达式类型一致（自动转换除外）
 * 				2.条件运算可以嵌套使用
 * 			
 * @author Administrator
 *
 */
public class Demo01 {
	//程序的入口（main方法）
	public static void main(String[] args) {
		int a0=3<2?1:3;
		System.out.println("a0="+a0);
		
		/*
		 * int a=1;
		 * int b=2;
		 * int c=3;
		 *要求：a<b且a<c时输出“true“,否则输出”false“
		 */
		int a=1;
		int b=2;
		int c=3;
		String str=a<b&&a<c?"true":"false";
		System.out.println("str="+str);
		//三目运算的嵌套
		String str1=a<b?a<c?"true":"false":"false";
		System.out.println("str1="+str1);
		
		
	}

}



















































