package com.xms.basic.day07;
/**
 * 同一个类中不允许两个相同的方法（方法名和参数列表相同）
 * 
 * 
 * 方法的重载：同一个类中，方法名相同，参数列表不同(参数的类型,参数的个数,
 * 						参数的位置（没有意义）)称之为方法的重载,与返回值无关
 * 
 * 重载的意义:降低客户的使用负担
 * 
 * 编译器在进行方法调用时，根据方法名和参数调用对应的方法，java 中
 * 允许多个方法名相同，参数列表不同的方法（重载），根据参数的不同
 * 编辑器自动识别并调用对应的方法（重载是多个不同的方法）
 * @author Administrator
 *
 */
public class Demo02 {
	//现金支付
	public void payCash(double money) {
		System.out.println("现金");
	}
	
	//支票
	public static void payCheck(String name,double money) {
		System.out.println("支票");
	}
	
	//信用卡
	public void payCard(String name,String pwd) {
		System.out.println("信用卡");
	}
	
	//重载
	//现金
	public void pay(double money) {
		System.out.println("现金");
	}
	//信用卡
	public void pay(String name,String pwd) {
		System.out.println("信用卡");
	}
	
	//支票
	public void pay(String name,double money) {
		System.out.println("支票");
	}
	
//	public int add(int a) {
//		System.out.println("add1");
//		return 10;
//	}
//	public void add(int a) {
//		System.out.println("add2");
//	}
	
	

}
