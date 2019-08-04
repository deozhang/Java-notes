package com.xms.basic.day03;

import java.util.Scanner;

/**
 * 分支语句：
 * 			if-else if语句：有多种情况需要判断（大于2种）根据不同的条件，
 * 									执行不同的结果，满足某些条件，执行某些语句后
 * 									整个if-else if结束
 * 			语法结构：
 * 					if(布尔类型表达式){
 * 							逻辑语句1
 * 					}else if(布尔类型表达式){
 * 							逻辑语句2
 * 					}else if(布尔类型表达式){
 * 							逻辑语句3
 *					}......
 * 					剩余有效代码
 * 
 * 			执行流程：从上到小逐一判断对应的布尔类型表达式，如果某一个
 * 							布尔类型，满足条件为true,则执行对应的逻辑语句，然后
 * 							整个if-else if结束
 * 
 * 			各个语句之间内置的为互斥关系
 * 							
 * 
 * 总结：
 * if:其实有很多情况，但是只写出需要判断的某一种情况进行判断---一条路
 * if-else:将整个事件划分成两种情况，必然会执行某一个情况---两条路
 * if--else if：将整个事件划分成2种以上的情况，然后尽心逐一判断----多条路
 * 
 * 
 * 
 * 
 * @author Administrator
 * 
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		/*
		 * - 成绩大于等于90分，优秀
			- 成绩大于等于80分，良好
			- 成绩大于等于60分，及格
			- 成绩小于60分，不及格
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的分数（int）：");
		int score=sc.nextInt();
		if(score>=90) {
			System.out.println("优秀");
		}else if(score>=80) {
			System.out.println("良好");
		}else if(score>=60) {
			System.out.println("及格");
		}else if(score<60) {
			System.out.println("不及格");
		}
		System.out.println("剩余的有效代码");
		System.out.println("----------------------------------------");
		//修改成相应的效果
		if(score<60) {
			System.out.println("不及格");
		}else if(score<80&&score>=60) {
			System.out.println("及格");
		}else if(score<90&&score>=80) {
			System.out.println("良好");
		}else if(score>=90) {
			System.out.println("优秀");
		}
		System.out.println("剩余的有效代码");
		
		
	}

}













































