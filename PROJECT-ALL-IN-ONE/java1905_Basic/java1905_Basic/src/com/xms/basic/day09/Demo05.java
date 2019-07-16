package com.xms.basic.day09;
/**
 * 程序运行：
 * 		.java--编译-->.class--->jvm加载运行-->new(创建对象)
 * 
 * static修饰符：
 * 			
 * 		成员变量：
 * 				实例变量：属于对象
 * 				静态变量(类变量)：是static修饰，属于类，所有对象共享一份（只有一份）
 * 		
 * 		static修饰的变量或者方法特性如下：
 * 		1.随着类的加载而加载，属于类
 * 		2.优先于对象存在
 * 		3.被类的所有对象共享，无论创建多少个对象，static修饰的成员变量或者方法
 * 			只有一份，存在方法区（静态区），且只会加载一次
 * 
 *    注意：
 *    	1.静态方法没有this关键字
 *    			--创建对象时，才有this关键字
 *    	2.静态方法只能访问静态变量/方法
 *    	3.非静态方法既能访问实例变量/成员方法
 *    						也能访问静态变量/静态方法
 *    
 *    	静态变量与实例变量的区别：
 *    		1.所属不同
 *    				实例变量---属于对象
 *    				静态变量---属于类
 *    		2.内存位置不同
 *    				实例变量---堆中
 *    				静态变量---方法区
 *    		3.在内存出现的时间段不同
 *    				实例变量：随着对象的 创建而存在，随着对象的消失，而消失
 *    				静态变量：随着类加载而存在，类的消失而消失
 *    		4.调用不同
 *    				实例变量：对象.（实例）变量名
 *    				静态变量：
 *    							对象.（静态）变量名		---不建议
 *    							类名.（静态）变量名		---建议
 *    
 *    	static代码块：
 *    		1.java中使用  {}括起来的代码叫做代码块
 *    		2.static{}:静态代码块，在加载类的执行，并且只执行一次，用于给类
 *    						进行初始化，一般加载驱动，（静态资源：图片，视频，音频...）
 *    	static好处:调用简单，使用方便快捷；
 * @author Administrator
 *
 */
public class Demo05 {
	//成员变量
	/*
	 * 非static方法属于对象
	 * static属于类（所有对象共享） 
	 */
	int a;//实例变量---属于对象
	static int b;//静态变量（类变量）--属于类（所有对象共享）
	
	//构造方法
	public Demo05() {
		a++;//1
		b++;//1
	}
	
	//成员方法--没有static修饰
	public void show() {
		System.out.println("成员方法--show()");
		System.out.println(a);
		System.out.println(b);
	}
	//静态方法
	public static void time() {
		System.out.println("静态方法--time()");
//		System.out.println(a);
		System.out.println(b);
	}
	//成员方法--没有static修饰
	public void show1() {
		System.out.println("成员方法--show1()");
		this.show();
		time();
	}
	//静态方法
	public static void time1() {
		System.out.println("静态方法--time1()");
//		show();
		time();
	}
	
	static{//静态代码块---给类进行初始化使用
		System.out.println("这是静态代码块");
		
	}

}
