package com.xms.basic.day06;

import java.util.Scanner;

/**
 * 方法：面向对象语言中完成或者执行某一个功能的逻辑代码块
 * 方法的封装：以某种语法来表示这段可供重复使用（调用）逻辑代码块
 * 方法的定义：
 * 		---五个要素：
 * 		程序入口（main方法）
 * 		public static void main(String[] args){
 * 			//逻辑代码块
 * 		}
 * 
 * 			public---公共的（权限修饰符）
 * 			static---静态的
 * 			修饰词：public static 
 * 			void---表示无返回值（可以根据实情况，定义返回值类型）
 * 			返回值:void
 * 			main---和变量名规则一致（全部用英文）
 * 			方法名：main
 * 			String[]---参数的类型
 * 			args---参数名（形式参数）
 * 			参数列表：String[] args
 * 			{}
 * 			方法体：{}表示逻辑功能的代码块
 * 
 * 注意：
 * 1.在一个类中，不能定义两个相同的方法（方法名和参数列表相同--相同的方法）
 * 	
 * 总结:目前定义的方法为static方法
 * 			1.定义方法的五要素：修饰词，返回值，方法名，参数列表，方法体
 * 			2.定义方法方法时，根据实际业务确定方法的参数列表：
 * 					1.如果该方法需要处理外部输入的参数，则参数列表定义成对应类型的参数
 * 					2.如果该方法不需要处理外部输入的参数，则参数列表可以定义为无参数的
 * 			3.定义方法方法时，根据实际业务确定方法的返回值：
 * 					1.如果需要该方法处理后产生数据，则定义该方法有返回值
* 							方法处理的结果：返回值
 * 						---return：表示方法结束，将结果返回给方法的调用者
 * 					2.如果该方法处理数据后，不需要结果做其他逻辑运算，则该方法
 * 							定义为无返回值
 * 						---void:表示无返回值
 * 						---return:表示方法结束
 * 			4.同一个类中，不能定义两个相同的方法（方法名和参数列表相同）
 * 			5.方法的调用：	
 * 					---调用方法时，从外部输出的参数，要与方法定义的参数的类型，
 * 						 位置，个数要一致,否则会编译报错
 * 					--调用的语法：
 * 							调用者和被调用者在同一个类中
 * 								--类名.方法名()  
 * 								--方法名()
 * 							调用者和被调用者不在同一个类中
 * 								--类名.方法名()  
 *			6.方法封装原则和好处：
 *					1. 封装方法尽可能做到功能单一
 *					2.封装可以提高代码复用率，降低代码的出错率
 *					3.可以提高代码维护性
 * @author Administrator
 *
 */
public class Demo01 {
	//main方法
	public static void main(String[] args) {
		/*方法的调用
		 * 语法：
		 * 			1.被调用的方法和调用的方法在同一个类中
		 * 					--类名.方法名
		 * 					--方法名
		 * 			2.被调用的方法和调用的方法不在同一个类中
		 * 					--类名.方法名
		 * 
		 * 		调用方法时注意：在调用方法时，如果方法有参数，则从外部输出的
		 * 									参数，需要和方法定义的参数的类型，个数，位置
		 * 									要一一匹配（自动类型转换除外）
		 * 
		 * */ 
		Demo01.sayHello();
//		sayHello();
		String s="world";
		int a=20;
		Demo01.sayAnything(s);
		Demo01.add1(1,3);
		int b=Demo01.add2(1,3);
		System.out.println(b);
		Demo01.add4(20,"hello");
		
		Demo01.method(2,"a","v","c","d");
		
		
	}
	
	/*
	 * 
	 * 1.在定义方法时，参数列表可有可无---根据实际情况
	 * 	   --在定义参数列表时，需要确定该方法处理的是什么类型的数据
	 * 		相同或者相似的方法：有参数要比无参数的更加灵活
	 * 										  参数多的要比参数少更加灵活
	 * 
	 */
	//说话方法---参数列表
	//1.说“hello”
	public static void sayHello() {
		System.out.println("hello");
	}
	//2.说指定语句
	public static void sayAnything(String str) {
		System.out.println(str);
	}
	
	int a;
	//计算两个int类型的相加的方法---返回值
	//无返回值--void
	public static void add1(int a,int b) {
		int c=a+b;
		System.out.println(c);
	}
	//有返回值--根据实际情况确定返回值类型
	//搭配一个return关键将数据返回给方法的调用者
	public static int add2(int a,int b) {
//		int c=a+b;
		//可以在return上做一些比较和算术运算等操作
		return a+b;//将数据处理的结果返回值方法的调用者--动作指令
	}
	
	
	public static double add3(int a,double b) {
		return a+b;
//		System.out.println("000");
		
	}
	
	public static void add4(double a,String str) {
		System.out.println(str+a);
		return;//表示方法结束
//		System.out.println("00");
	}
	
	/*
	 *定义一个方法：参数为一个int
	 *类型的数和不定个字符串类型参数
	 */
	public static void method(int a, String ...str) {
		System.out.println("method");
	}
	
//	public static void method1(int a,String b) {
//		System.out.println("method1");
//	}
//	public static void method2(int a,String b,String c) {
//		System.out.println("method2");
//	}
}













