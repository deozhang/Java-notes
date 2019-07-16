package com.xms.basic.day03;

import java.util.Scanner;//声明调用的工具类

/**
 * 分支结构：根据不同的条件执行不同程序
 * 		if语句
 * 		if-else语句
 * 		if-else if语句
 * 		switch-case语句
 * 
 * if语句：满足某些条件执行某些语句，不满足条件，则不执行某些语句
 * 				语法：
 * 					if(表达式){--表达式的结果为布尔类型
 * 						逻辑语句
 * 					}
 * 			执行流程：首先判断布尔类型表达式，如果布尔类型表达式为true，则
 * 							执行大括号中的逻辑语句；如果布尔类型表达式为false,则不
 * 							执行大括号中的逻辑语句。
 * 
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		/*
		 * 判断一个int类型的数是不是奇数
		 * 如果是奇数，则输出在控制台上
		 */
//		int a=6;
		//键盘输入数据的工具工具类
		//获取键盘输入的工具类
		Scanner sc=new Scanner(System.in);
		/*
		 * nextInt():将键盘输入的int类型数据获取到，然后
		 * 可以将值赋值给对应类型的变量
		 * 
		 * 该方法属于一个线程阻塞的方法
		 */
		System.out.println("请输入int类型的数：");
		int a=sc.nextInt();
		
		//条件运算
//		String str1=a%2!=0?"奇数":"";
//		System.out.println("str1="+str1);
		
		//分支--if语句
		if(a%2!=0) {
			System.out.println("是奇数1");
			System.out.println("是奇数2");
		}
		System.out.println("剩余代码");
		System.out.println("--------------if语句把大括号去掉----------------");
		/*
		 * if语句不加大括号也可以执行，但是只会执行if语句后的第一行代码
		 */
		if(a%2!=0)
			System.out.println("是奇数1");
			System.out.println("是奇数2");
		    System.out.println("剩余代码");
		
		
		
	}

}









































