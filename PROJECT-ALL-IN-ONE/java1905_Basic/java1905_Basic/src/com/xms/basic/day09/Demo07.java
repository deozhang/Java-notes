package com.xms.basic.day09;
/**
 * static final修饰常量：
 * 		1.static final修饰常量，必须在声明的同时初始化
 * 			不可更改，所有对象共享
 * 			语法：static final int NUM=10;
 * 		2.static final修饰的常量在，在编译时会将变量名替换成
 * 			直接值---效率高
 * 		
 * 			.java--编译--.class--jvm加载运行--new(对象)
 * 						常量					static				实例
 * 
 * static final：修饰常量，使用方便，执行效率高
 * @author Administrator
 *
 */
public class Demo07 {
	final static  int NUM=10;
//	public Demo07() {
//		NUM=11;
//	}

	public void add() {
//		NUM=20;
		System.out.println(NUM+10);//将NUM直接替换成10
		System.out.println(NUM-10);
	}
}





















