package com.xms.se.day09;
/**
 * 守护线程(后台线程)
 * 
 * 守护线程和普通线程没有什么区别，我们可以通过
 * Thred类提供的方法，将普通线程设置成守护线程（后台线程）
 *
 * 守护线程的特点：当当前线程中，只剩下守护线程时，所有守护线程将强制终止，
 * 如果还有一个前台线程存在，守护线程都不会终止。
 * gc()--典型的建立在守护线程上的方法
 *
 * isDaemon():判断当前线程是否是守护线程
 * 		true--守护线程
 * 		false--不是守护线程
 * void setDaemon(boolean bo):设置当前线程为守护线程（true）
 * @author deo
 *
 */
public class Demo03Thread {
	public static void main(String[] args) {
		//rose
		Thread rose=new Thread() {
			public void run(){
				for(int i=0;i<=5;i++) {
					System.out.println("rose:let me go!!!");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("rose:啊啊啊啊！！！");
				System.out.println("音效：噗通！！！！");
			}
		};
		//jack
		Thread jack=new Thread() {
			public void run() {
				while(true) {
					System.out.println("jack:you jump,i jump!!!");
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		rose.start();
		
		/*
		 * 将jack线程设置成守护线程
		 * 注意：需要在线程启动前设置，否则没有效果
		 */
		jack.setDaemon(true);
		jack.start();
		boolean bo1=jack.isDaemon();
		System.out.println(bo1);
		

	}
		
	}














