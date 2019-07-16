package com.xms.basic.day03;

import java.util.Scanner;

/**
 * 分支语句:
 * 			if-else:满足某些条件执行某些语句，不满足某些条件
 * 						执行另外某些语句
 * 		语法：
 * 				if(布尔类型表达式){
 * 					逻辑语句1
 * 				}else{
 * 					逻辑语句2
 * 				}
 * 				剩余代码
 * 		执行流程：首先判断布尔表达式，如果布尔表达式为true,则执行if
 * 						大括号中的逻辑语句，如果布尔类型表达式为false,则执
 * 						行else括号的逻辑语句，两者执行其中之一后，整个if-else
 * 						结束执行剩余有效代码
 * 
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		/*
		 * 判断一个int类型的数字，是大于0 还是小于等于0的数字
		 */
		//获取键盘输入的工具类
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入int类型的数字：");
		//调用获取键盘数字的方法，将数据获取，并且赋值给对应类型的变量
		int num=sc.nextInt();
		if(num>0) {
			System.out.println("这是一个大于0的int类型的数字");
		}else {
			System.out.println("这是一个小于等于0的int类型的数字");
			
		}
		System.out.println("剩余有效代码");
	}

}













































