package com.xms.se.day09;
/**
 * ���̶߳�дͬһ�ٽ���Դ�����İ�ȫ���⣺�첽--->ͬ��
 * 1.���̹߳���ʵ������
 * 2.���̹߳���̬����
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
			throw new RuntimeException("û�ж�����");
		}
//		//���õ�ǰ�̵߳�ʱ��Ƭ--������̲߳����ĸ���
//		Thread.yield();
		return beans--;
	}
}
