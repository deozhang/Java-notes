package com.xms.basic.day03;

import java.util.Scanner;//�������õĹ�����

/**
 * ��֧�ṹ�����ݲ�ͬ������ִ�в�ͬ����
 * 		if���
 * 		if-else���
 * 		if-else if���
 * 		switch-case���
 * 
 * if��䣺����ĳЩ����ִ��ĳЩ��䣬��������������ִ��ĳЩ���
 * 				�﷨��
 * 					if(���ʽ){--���ʽ�Ľ��Ϊ��������
 * 						�߼����
 * 					}
 * 			ִ�����̣������жϲ������ͱ��ʽ������������ͱ��ʽΪtrue����
 * 							ִ�д������е��߼���䣻����������ͱ��ʽΪfalse,��
 * 							ִ�д������е��߼���䡣
 * 
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		/*
		 * �ж�һ��int���͵����ǲ�������
		 * �����������������ڿ���̨��
		 */
//		int a=6;
		//�����������ݵĹ��߹�����
		//��ȡ��������Ĺ�����
		Scanner sc=new Scanner(System.in);
		/*
		 * nextInt():�����������int�������ݻ�ȡ����Ȼ��
		 * ���Խ�ֵ��ֵ����Ӧ���͵ı���
		 * 
		 * �÷�������һ���߳������ķ���
		 */
		System.out.println("������int���͵�����");
		int a=sc.nextInt();
		
		//��������
//		String str1=a%2!=0?"����":"";
//		System.out.println("str1="+str1);
		
		//��֧--if���
		if(a%2!=0) {
			System.out.println("������1");
			System.out.println("������2");
		}
		System.out.println("ʣ�����");
		System.out.println("--------------if���Ѵ�����ȥ��----------------");
		/*
		 * if��䲻�Ӵ�����Ҳ����ִ�У�����ֻ��ִ��if����ĵ�һ�д���
		 */
		if(a%2!=0)
			System.out.println("������1");
			System.out.println("������2");
		    System.out.println("ʣ�����");
		
		
		
	}

}









































