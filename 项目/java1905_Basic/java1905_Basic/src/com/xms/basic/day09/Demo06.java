package com.xms.basic.day09;
/**
 * final修饰词--最终的
 * 
 * 1.修饰成员变量：在修饰成员变量后，该成员变量必须初始化，不可改变
 * 				--1.在声明的同时初始化
 * 				--2.在构造方法中初始化
 * 				 final也可以修饰局部变量----几乎不用
 * 		
 * 	2.修饰方法：用final修饰的方法，该方法不能被重写（但是能被继承）
 * 		意义：使一个方法不能被重写的意义，防止子类在定义方法时“不经意”
 * 				  重写了父类的方法
 * 3.修饰类：用final修饰类，该类不能被继承，但是可以继承别的类（不能用final修饰）
 * 		意义：使一个不能继承的意义：防止继承的滥用，对系统造成的伤害
 * 
 * 
 * @author Administrator
 *
 */
public final class Demo06 {
//	String
//	Integer
	
	
	
	final int a;
//	final int a=10;//声明的同时初始化
	
	public Demo06() {
		a=11;
	}
	
	public final void add() {
		System.out.println("Deno06-add()");
	}
	
	
	public static void main(String[] args) {
		Demo06 d=new Demo06();
//		Demo07 d1=new Demo07();
		
		
	}

}

//class Demo07 extends Demo06{
//	public  void add() {
//		System.out.println("Demo07-add()");
//	}
//}





























