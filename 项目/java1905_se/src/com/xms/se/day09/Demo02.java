package com.xms.se.day09;

import java.lang.Thread.State;

/**
 *  线程的方法(不常用)
 * @author deo
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		/*
		 * currentThread():查看当前线程
		  *  返回值为Thread类型
		 *  Thread[main,5,main]
		  *   线程名,优先级,线程组名
		 *  
		 *  
		 */
		Thread t=Thread.currentThread();
		System.out.println(t);
		
		
		//创建线程
		Thread t1=new Thread() {
			public void run() {
				//执行的任务--内容
				Thread t2=Thread.currentThread();
				System.out.println(t2);
			}
		};
		t1.start();
		/*
		 * getId():获取当前线程的标识,
		 * 返回值long类型
		 * 获取的id值为计算机随机分配,且唯一不重复
		 */
		long id=t.getId();
		System.out.println(id);
		
		/*
		 * getName():
		 * 获取当前的线程的线程名
		 * 返回值为String类型
		 */
		String name1=t.getName();
		System.out.println("name1:"+name1);
		/*
		 * getPriority():获取当前线程的优先级
		 * 返回值为int类型
		 * 
		 * 线程的优先级为1-10,等级越高,获取时间片的概率越大(1为最低,10为最高)
		 * 
		 * 线程的切换是由线程调度控制,我们无法通过代码来干涉,但是可以提高线程的
		 * 优先级来最大化的改变线程获取时间片的概率
		 * 
		 * 需要在线程启动前设置,否则不生效
		 * setPriority(int num):设置线程的优先级(num 1~10)
		 * 常量:
		 * 最高等级:Thread.MAX_PRIORITY 10
		 * 最低等级:Thread.MIN_PRIORITY 1
		 * 正常等级:Thread.NORM_PRIORITY 5
		 */
		//获取线程的优先级
		int num1=t1.getPriority();
		System.out.println("num1:"+num1);
		//设置线程的优先级
		t1.setPriority(Thread.MAX_PRIORITY);
		
		int num2=t1.getPriority();
		System.out.println("num2:"+num2);
		
		/*
		 * getState():
		 * Thread类获取线程状态的方法
		 * 返回值为state类型(线程的状态的类型)
		 * 
		 * isAlive():
		 * 查看当前线程是否处于活动状态
		 * 返回值为布尔类型
		 * true--活动
		 * false--停止状态(死亡)
		 */
		State state=t.getState();
		System.out.println(state);
		boolean bo1=t.isAlive();
		System.out.println(bo1);
	}
}











