package com.xms.se.day09;
/**
 * �ػ��߳�(��̨�߳�)
 * 
 * �ػ��̺߳���ͨ�߳�û��ʲô�������ǿ���ͨ��
 * Thred���ṩ�ķ���������ͨ�߳����ó��ػ��̣߳���̨�̣߳�
 *
 * �ػ��̵߳��ص㣺����ǰ�߳��У�ֻʣ���ػ��߳�ʱ�������ػ��߳̽�ǿ����ֹ��
 * �������һ��ǰ̨�̴߳��ڣ��ػ��̶߳�������ֹ��
 * gc()--���͵Ľ������ػ��߳��ϵķ���
 *
 * isDaemon():�жϵ�ǰ�߳��Ƿ����ػ��߳�
 * 		true--�ػ��߳�
 * 		false--�����ػ��߳�
 * void setDaemon(boolean bo):���õ�ǰ�߳�Ϊ�ػ��̣߳�true��
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
				System.out.println("rose:��������������");
				System.out.println("��Ч����ͨ��������");
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
		 * ��jack�߳����ó��ػ��߳�
		 * ע�⣺��Ҫ���߳�����ǰ���ã�����û��Ч��
		 */
		jack.setDaemon(true);
		jack.start();
		boolean bo1=jack.isDaemon();
		System.out.println(bo1);
		

	}
		
	}














