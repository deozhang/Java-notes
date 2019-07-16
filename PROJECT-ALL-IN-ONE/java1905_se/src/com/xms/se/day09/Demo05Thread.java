package com.xms.se.day09;
/*
 * 多线程并发安全问题
 * 
 * 产生多线程并发安全问题的原因：多个线程并发操作同一个数据
 * 解决方案：将异步变成同步
 * 解决措施：加锁--同步锁
 * 描述一个类是否安全：该类的相关方法是否加锁，加锁为线程安全，不加锁为非线程安全
 * 互斥锁：（加在不同的方法上，保证多个线程在调用这些方法时，同一时刻，只能调用一个方法）
 * 死锁：（）
 * 引入关键字：synchronzed--将异步变成同步
 * 1.加方法上——弊端：执行效率低
 * 2.加载需要同步的代码块上
 * 
 */
public class Demo05Thread {
	static Object obj=new Object();
public static void main(String[] args) {
	/*
	 * 去商场买衣服
	 * 商场--共同资源（试衣间：需要同步的代码块）
	 * 顾客1--线程
	 * 顾客2--线程
	 * 顾客3--线程
	 */
	//顾客1
	Thread t1=new Thread() {
		public void run() {
			buy("张三");
		}
	};
	//顾客2
	Thread t2=new Thread() {
		public void run() {
			buy("李四");
		}
	};
	t1.start();
	t2.start();
}
//公共资源
public static void buy(String name) {
	try {
		System.out.println(name+"进入商场");
		System.out.println(name+"挑选衣服");
		Thread.sleep(3000);
		/*
		 * 大括号中是需要同步的代码块
		 * 小括号中需要有一个对象锁，此时该对象是什么类型的都可以
		 *一般使用jdk封装的Object类型对象，这样可以不用创建其他类，节省资源
		 */
		synchronized(obj) {
			 System.out.println(name+"进入试衣间");
			 System.out.println(name+"正在试衣服");
			 Thread.sleep(2000);
		}
		System.out.println(name+"出试衣间");
		System.out.println(name+"付款");
		Thread.sleep(1000);
		System.out.println(name+"出商场");
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
