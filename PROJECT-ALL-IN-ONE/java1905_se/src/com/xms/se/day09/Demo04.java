package com.xms.se.day09;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �̳߳��õķ���
 * @author deo
 *
 */
public class Demo04 {
	public static void method1() {
		/*
		 * sleep(long ms):��λ����
		 * Thread��ľ�̬����������ʹ�õ�ǰ�߳̽�������״̬
		 *   ָ����������������ָ��������������״̬���������뵽Runnable���ȴ�
		 *   ����ʱ��Ƭ
		 */
		Thread t=new Thread() {
			public void run() {
				for(int i=0;i<=10;i++) {
					System.out.println(i);
					try {
						//��Ϊ�ṩ�ӳ�--��Ӧʱ��
						Thread.sleep(1000);//��λ����
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
		 * ʱ�����
		 * 15��55��20
		 * 15��55��21
		 * 15��55��22
		 * ............
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		while(true) {
			Date date=new Date();
			String strTime=sdf.format(date);
			System.out.println(strTime);
			try {
				//�ϸ�������������1��һ�� 
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void method2() {
		/*
		 * void join():(���߳�ͬ�������Ⱥ�ִ��˳��)
		 * �÷������ڵȴ���ǰ�߳̽��������׳��쳣
		 * 
		 * a,b�����߳�
		 * �����Ҫ�ﵽ��b�߳���a�߳̽�����,b�߳���ִ�У�
		 * ����Ҫ��b�߳�ִ������ǰ a.join()
		 * 
		 * ������ͼƬ����չʾͼƬ
		 * load�������߳�--
		 * show:չʾ�߳�
		 * 
		 * �����߳���ִ����ɣ���ִ��չʾ�߳�
		 * 
		 */
		/*
		 * �����ж�����࣬�����ֲ��ڲ��࣬��������д����֮Ϊ
		 * �ֲ������ڲ���
		 * 
		 * ���Ҫ�������е��ڲ�����Ҫ���ø÷����е�����������
		 * ����Ҫ�þֲ�����Ϊfinal����--�﷨��jdk1.6��
		 * 
		 * jdk1.8�ӻ��߲��Ӷ��У�ʡ�ԣ�
		 */
		//�����߳�
		Thread load = new Thread() {
			public void run() {
				System.out.println("ͼƬ��ʼ����");
				for(int i=0;i<=100;i++) {
					System.out.println("ͼƬ�Ѿ�����"+i+"%");
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		//չʾ�߳�
		Thread show=new Thread() {
			public void run() {
				//�������������չʾ����ʼ
				try {
					load.join();
					System.out.println("ͼƬ��ʼչʾ");
					Thread.sleep(500);
					System.out.println("ͼƬչʾ���");
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

















