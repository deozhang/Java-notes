package com.xms.basic.day04;
/**
 * 循环结构：
 * 		语法：
 * 			do{   ---直到型循环
 * 				循环体
 * 			}while(布尔类型表达式);
 * 		执行流程：先执行do中的循环体，然后再判断while中布尔类型的表达式
 * 						如果布尔类型表达式为true,则继续执行do中的循环体，循环往
 * 						复判断执行，直到布尔类型表达式为false,循环结束
 * 					
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		/*
		 * 输出十句“hello world”
		 */
		int i=0;//循环的初始条件
		do {
			System.out.println("hello world");//循环体
			i++;//循环体--初始的条件的变化量
		}while(i<10);//判断条件
		System.out.println("剩余有效代码");
	}

}





































