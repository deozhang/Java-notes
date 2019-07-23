package com.xms.basic.day04;
/***
 * 循环结构：
 * 		一组相同或者相似的逻辑代码被重复执行
 * 		while循环,do-while循环，for循环
 * 		
 * 		循环的要素：
 * 				1.循环体--需要重复执行的逻辑代码块
 * 				2.循环条件--以次数来进行控制
 * 		语法:
 * 			while(布尔类型的表达式){
 * 				循环体
 * 			}
 * 		执行流程：先判断布尔类型表达式，如果布尔类型的表达式为true,
 * 						 则执行循环体，循环体执行完后，再回头判断布尔类型
 * 						 表达式，如果布尔表达式为true，则继续执行循环体，
 * 						 循环往复，直到布尔类型表达式为false，循环结束，如果
 * 						 布尔类型表达式一直为true，则该循环为死循环（尽量避免）
 * 		
 * 
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		/*
		 * 输出十句“hello world”
		 */
		int i=0;//循环的初始条件
		while(i<10) {//循环的判断条件--当循环
			//一组相同或者相似的代码
			System.out.println("hello world");//循环体
			i++;//初始条件的变化量--循环体
		}
		System.out.println("剩余有效代码");
	}

}






































