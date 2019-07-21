package com.xms.se.day09;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池：
 *     ExecutorService是java提供的用于管理线程池的接口
 *     当一个程序中若大量创建线程，并且在任务结束后销毁线程，
 *     会给系统带来过度的资源消耗，为此我们一个使用线程池来缓解该问题。
 *
 *     作用：
 *          1.控制线程数量
 *          2.重用线程
 *
 *     创建线程池：
 *          Exceutors.newCacehedThreadPool(int nThread)---网页
 *          创建可根据需要创建新线程的线程池，但是在以前创建的线程可用时，
 *          将重用他们。
 *          Executors.newFixedThreadPool(int nThread)---最常用
 *          创建一个可重用的固定线程集合的线程池，以无界队列的方式来运行这些线程。
 */
public class Demo10Thread {
    public static void main(String[] args) {
        //1.创建线程池
        ExecutorService poll = Executors.newFixedThreadPool(2);
        //2.创建任务类
        Runnable run1 = new Runnable(){
            public void run(){
                for (int i = 0; i < 6; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable run2 = new Runnable(){
            public void run(){
                for (int i = 0; i < 6; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable run3 = new Runnable(){
            public void run(){
                for (int i = 0; i < 6; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        //3.将任务类，纳入到线程池中，进行统一管理。
        /**
         * execute(Runnable run)
         * 该方法将指定的任务，纳入到线程池中，进行统一管理
         * (搭载线程，启动线程...)
         */
        poll.execute(run1);
        poll.execute(run2);
        poll.execute(run3);
    }
}
