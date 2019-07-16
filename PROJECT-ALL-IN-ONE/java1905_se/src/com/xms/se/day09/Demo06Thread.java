package com.xms.se.day09;
/**
 * 多线程读写同一临界资源引发的安全问题：异步--->同步
 * 1.多线程共享实例变量
 * 2.多线程共享静态变量
 * @author deo
 *
 */
public class Demo06Thread {
	static int beans=20;
	public static void main(String[] args) {
		Thread t1=new Thread() {
			public void run() {
				while(true) {
					System.out.println(getBeans());
				}
			}
		};
		Thread t2=new Thread() {
			public void run() {
				while(true) {
					System.out.println(getBeans());
				}

			}
		};
		t1.start();
		t2.start();
		
	}
	public synchronized static int getBeans() {
		if(beans==0) {
			throw new RuntimeException("没有豆子了");
		}
//		//出让当前线程的时间片--增大多线程并发的概率
//		Thread.yield();
		return beans--;
	}
}
