package com.xms.basic.day09;
/**
 * static final���γ�����
 * 		1.static final���γ�����������������ͬʱ��ʼ��
 * 			���ɸ��ģ����ж�����
 * 			�﷨��static final int NUM=10;
 * 		2.static final���εĳ����ڣ��ڱ���ʱ�Ὣ�������滻��
 * 			ֱ��ֵ---Ч�ʸ�
 * 		
 * 			.java--����--.class--jvm��������--new(����)
 * 						����					static				ʵ��
 * 
 * static final�����γ�����ʹ�÷��㣬ִ��Ч�ʸ�
 * @author Administrator
 *
 */
public class Demo07 {
	final static  int NUM=10;
//	public Demo07() {
//		NUM=11;
//	}

	public void add() {
//		NUM=20;
		System.out.println(NUM+10);//��NUMֱ���滻��10
		System.out.println(NUM-10);
	}
}





















