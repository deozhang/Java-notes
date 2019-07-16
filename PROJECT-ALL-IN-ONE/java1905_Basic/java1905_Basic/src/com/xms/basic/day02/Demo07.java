package com.xms.basic.day02;
/**
 * 逻辑运算符：
 * 符号：
 * 	&&(与)：两边同时为真，整个运算结果为真，有一边为假，整个运算结果都为假
 * ||（或）:两边有一边为真，整个运算结果为真，两边同时为假，整个运算结果才为假
 * !(取反):将整个表达式或者变量取相反的结果（true<--->false）
 * 1.参数逻辑运算的变量或者表达式都为boolean类型
 * 2.逻辑运算符的结果也为boolean类型
 * @author Administrator
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		System.out.println("---------&&-----------------------------------------------");
		System.out.println(3>2&&3>2);//t
		System.out.println(3<2&&3<2);//f
		System.out.println(3>2&&3<2);//f
		System.out.println(true&&3<2);//f
		System.out.println("---------||-----------------------------------------------");
		System.out.println(3>2||3>2);//t
		System.out.println(3<2||3<2);//f
		System.out.println(3>2||3<2);//t
		System.out.println(true||3<2);//t
		System.out.println("---------!-----------------------------------------------");
		System.out.println(!(3>2||3>2));//f
		System.out.println(!true||3<2);//f
		System.out.println();
		
		/*
		 * &&和&及||和|的区别：在运算结果上没有差别，差别只是在
		 *										 写法上的不同导致整个执行效率不同
		 */
		System.out.println("---------&-----------------------------------------------");
		System.out.println(3>2&3>2);//t
		
		System.out.println(3<2&&3<2);//f
		System.out.println(3<2&3<2);//f
		
		System.out.println(3>2&3<2);//f
		System.out.println(true&3<2);//f
		System.out.println("---------|-----------------------------------------------");
		System.out.println(3>2||3>2);//t
		System.out.println(3>2|3>2);//t
		
		System.out.println(3<2|3<2);//f
		
		System.out.println(3>2||3<2);//t
		System.out.println(3>2|3<2);//t
		
		System.out.println(true||3<2);//t
		System.out.println(true|3<2);//t
		
		
		
	}

}


















































