package com.xms.se.day09;
/**
 * 	操作系统---进程---线程
 * 
 * 	进程:进程是操作系统中运行的一个任务,进程中包含了某些共同资源的内存区域,
 * 		操作系统利用进程把他的工作划分成一个个功能执行单元,
 *	线程:进程中包含的一个或者多个功能执行单元称之为线程,
 * 		线程只能归属于一个进程,并且只能访问该进程所拥有的资源
 * 
 * 	线程和进程的区别:
 * 	1.进程的划分尺度要大于线程,一个进程中至少包含一个线程
 * 	2.进程尺度要大于线程,使得多线程的程序并发性高,另外进程在执行过程中拥有独立的内存单元,
 * 	而多个线程共享该内存,提高程序的运行效率和资源利用率
 * 	3.多线程的意义在于一个应用程序中,有多个执行部分可以同时执行,但是操作系统并没有将多个线程
 * 	看成独立的应用来实现进程的调度管理和资源分配.
 * 
 * 	多线程的使用场景:
 * 	1.通常在一个应用程序中需要有多个任务同时进行的情况,我们可以将每个任务定义为一个线程,
 * 	使得他们能一同工作
 * 	2.一个应用程序中可以使用单一线程完成某件任务,也可以使用多个线程达到更快完成对应的任务
 * 
 * 	并发原理:
 * 	多个线程"同时"运行,只是我们感官上的体验,事实上多个线程并发运行时,线程调度将时间尽可能的
 * 	均匀划分成多个时间片段(时间片),某个线程获取到时间片时,则会被CPU执行,其他全部线程处于
 * 	等待状态,等该线程时间片用完后,另外的其他获取时间片的线程会被CPU执行.
 * 	所以微观上各个线程是处于走走停停的状态,这种现象叫做并发,但是不是绝对意义上的"同时发生".
 * 
 * 	同步&&异步
 * 	同步:指有先后顺序的执行方式
 * 	异步:各自执行各自的任务,互不干扰,可以同时进行.
 * 
 * 	如何创建线程:
 * 	1.继承Thread类--Thread类是线程类
 * 		--任务和线程在一起(耦合度强)
 * 	2.实现Runnable接口--Runnablle是一个任务接口,有一个书写任务的方法
 * 		--任务和线程是分开的(耦合度弱)--常用
 * 	3.线程池
 * @author deo
 *	
 */
public class Demo01Thread {
	public static void method1() {
		/*
		 * 1.继承Thread类
		 */
		//同步
//		for(int i=0;i<100;i++) {
//			System.out.println("000000");
//		}
//		for(int i=0;i<100;i++) {
//			System.out.println("111111");
//		}
		//异步
		System.out.println("#########################################");
		//创建线程
		Thread t1=new Thread1();
		Thread t2=new Thread2();
		/*
		 * 	启动线程
		 * 	注意:启动线程是start()不是run()
		 */
		t1.start();
		t2.start();
	}
	public static void method2() {
		/*
		 * 	实现Runnable接口
		 * 	--实现类实现
		 * 	--匿名内部类
		 */
		//实现类实现
		//任务类对象
		Runnable1 run1=new Runnable1();
		Runnable2 run2=new Runnable2();
		//创建线程--将任务类搭载到对应的线程上
		Thread t1=new Thread(run1);
		Thread t2=new Thread(run2);
		/*
		 * start()方法启动线程后,并不是说线程立刻就进入运行状态
		 * 	而是进入Runnable(等待分配时间片),如果某个线程分配到时间片,则该线程开始运行
		 */
		t1.start();
		t2.start();
		//匿名内部类
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				//任务内容
				for(int i=0;i<1000;i++) {
					System.out.println("Hello Deo");
				}
			}
		};
		//创建线程,搭载任务
		Thread tt=new Thread(run);
		tt.start();
		Runnable run3=new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<1000;i++) {
					System.out.println("匿名内部类");
				}
			}
		};
		Thread t3=new Thread(run3);
		t3.start();
	}
	public static void main(String[] args) {
		method1();
//		method2();
	}
}

//1.继承线程类  --Thread
class Thread1 extends Thread{
	//任务
	public void run() {
		//写需要执行的内容(任务)
		for(int i=0;i<1000;i++) {
			System.out.println(6*6*6*6*6);
		}
	}
}
class Thread2 extends Thread{
	//任务
	public void run() {
		//写需要执行的内容(任务)
		for(int i=0;i<1000;i++) {
			System.out.println(8*8*8*8*8);
		}
	}
}

//2.实现Runnable接口--实现的类称之为任务类
class Runnable1 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(6*6*6*6*6);
		}
	}
}
class Runnable2 implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(8*8*8*8*8);
		}
	}
}











