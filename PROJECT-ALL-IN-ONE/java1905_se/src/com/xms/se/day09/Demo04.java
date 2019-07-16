package com.xms.se.day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程常用的方法
 * @author deo
 *
 */
public class Demo04 {
	public static void method1() {
		/*
		 * sleep(long ms):单位毫秒
		 * Thread类的静态方法，用于使用当前线程进入阻塞状态
		 *   指定毫秒数，当到达指定毫秒数后，阻塞状态结束，进入到Runnable，等待
		 *   分配时间片
		 */
		Thread t=new Thread() {
			public void run() {
				for(int i=0;i<=10;i++) {
					System.out.println(i);
					try {
						//人为提供延迟--反应时间
						Thread.sleep(1000);//单位毫秒
					} catch (InterruptedException e) {
						e.printStackTrace();
						
					}
				}
			}
		};
		t.start();
	}
	public static void test01() {
		/*
		 * 时间读秒
		 * 15：55：20
		 * 15：55：21
		 * 15：55：22
		 * ............
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		while(true) {
			Date date=new Date();
			String strTime=sdf.format(date);
			System.out.println(strTime);
			try {
				//严格意义上做不到1秒一次 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void method2() {
		/*
		 * void join():(让线程同步，有先后执行顺序)
		 * 该方法用于等待当前线程结束，会抛出异常
		 * 
		 * a,b两个线程
		 * 如果想要达到：b线程在a线程结束后,b线程再执行，
		 * 则需要再b线程执行任务前 a.join()
		 * 
		 * 先下载图片，再展示图片
		 * load：下载线程--
		 * show:展示线程
		 * 
		 * 下载线程先执行完成，再执行展示线程
		 * 
		 */
		/*
		 * 方法中定义的类，叫做局部内部类，以匿名的写法称之为
		 * 局部匿名内部类
		 * 
		 * 如果要给方法中的内部类想要调用该方法中的其他变量，
		 * 则需要该局部变量为final修饰--语法（jdk1.6）
		 * 
		 * jdk1.8加或者不加都有（省略）
		 */
		//下载线程
		Thread load = new Thread() {
			public void run() {
				System.out.println("图片开始下载");
				for(int i=0;i<=100;i++) {
					System.out.println("图片已经下载"+i+"%");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		//展示线程
		Thread show=new Thread() {
			public void run() {
				//下载任务结束后，展示任务开始
				try {
					load.join();
					System.out.println("图片开始展示");
					Thread.sleep(500);
					System.out.println("图片展示完毕");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		load.start();
		show.start();
	}
	
	public static void main(String[] args) {
//		method1();
//		test01();
		method2();
	}
}

















