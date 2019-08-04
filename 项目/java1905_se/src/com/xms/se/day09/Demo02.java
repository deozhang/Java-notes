package com.xms.se.day09;

import java.lang.Thread.State;

/**
 *  �̵߳ķ���(������)
 * @author deo
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		/*
		 * currentThread():�鿴��ǰ�߳�
		  *  ����ֵΪThread����
		 *  Thread[main,5,main]
		  *   �߳���,���ȼ�,�߳�����
		 *  
		 *  
		 */
		Thread t=Thread.currentThread();
		System.out.println(t);
		
		
		//�����߳�
		Thread t1=new Thread() {
			public void run() {
				//ִ�е�����--����
				Thread t2=Thread.currentThread();
				System.out.println(t2);
			}
		};
		t1.start();
		/*
		 * getId():��ȡ��ǰ�̵߳ı�ʶ,
		 * ����ֵlong����
		 * ��ȡ��idֵΪ������������,��Ψһ���ظ�
		 */
		long id=t.getId();
		System.out.println(id);
		
		/*
		 * getName():
		 * ��ȡ��ǰ���̵߳��߳���
		 * ����ֵΪString����
		 */
		String name1=t.getName();
		System.out.println("name1:"+name1);
		/*
		 * getPriority():��ȡ��ǰ�̵߳����ȼ�
		 * ����ֵΪint����
		 * 
		 * �̵߳����ȼ�Ϊ1-10,�ȼ�Խ��,��ȡʱ��Ƭ�ĸ���Խ��(1Ϊ���,10Ϊ���)
		 * 
		 * �̵߳��л������̵߳��ȿ���,�����޷�ͨ������������,���ǿ�������̵߳�
		 * ���ȼ�����󻯵ĸı��̻߳�ȡʱ��Ƭ�ĸ���
		 * 
		 * ��Ҫ���߳�����ǰ����,������Ч
		 * setPriority(int num):�����̵߳����ȼ�(num 1~10)
		 * ����:
		 * ��ߵȼ�:Thread.MAX_PRIORITY 10
		 * ��͵ȼ�:Thread.MIN_PRIORITY 1
		 * �����ȼ�:Thread.NORM_PRIORITY 5
		 */
		//��ȡ�̵߳����ȼ�
		int num1=t1.getPriority();
		System.out.println("num1:"+num1);
		//�����̵߳����ȼ�
		t1.setPriority(Thread.MAX_PRIORITY);
		
		int num2=t1.getPriority();
		System.out.println("num2:"+num2);
		
		/*
		 * getState():
		 * Thread���ȡ�߳�״̬�ķ���
		 * ����ֵΪstate����(�̵߳�״̬������)
		 * 
		 * isAlive():
		 * �鿴��ǰ�߳��Ƿ��ڻ״̬
		 * ����ֵΪ��������
		 * true--�
		 * false--ֹͣ״̬(����)
		 */
		State state=t.getState();
		System.out.println(state);
		boolean bo1=t.isAlive();
		System.out.println(bo1);
	}
}











