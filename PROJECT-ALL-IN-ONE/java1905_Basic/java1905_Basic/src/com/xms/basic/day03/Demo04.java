package com.xms.basic.day03;

import java.util.Scanner;

/**
 * ��֧��䣺
 * 			if-else if��䣺�ж��������Ҫ�жϣ�����2�֣����ݲ�ͬ��������
 * 									ִ�в�ͬ�Ľ��������ĳЩ������ִ��ĳЩ����
 * 									����if-else if����
 * 			�﷨�ṹ��
 * 					if(�������ͱ��ʽ){
 * 							�߼����1
 * 					}else if(�������ͱ��ʽ){
 * 							�߼����2
 * 					}else if(�������ͱ��ʽ){
 * 							�߼����3
 *					}......
 * 					ʣ����Ч����
 * 
 * 			ִ�����̣����ϵ�С��һ�ж϶�Ӧ�Ĳ������ͱ��ʽ�����ĳһ��
 * 							�������ͣ���������Ϊtrue,��ִ�ж�Ӧ���߼���䣬Ȼ��
 * 							����if-else if����
 * 
 * 			�������֮�����õ�Ϊ�����ϵ
 * 							
 * 
 * �ܽ᣺
 * if:��ʵ�кܶ����������ֻд����Ҫ�жϵ�ĳһ����������ж�---һ��·
 * if-else:�������¼����ֳ������������Ȼ��ִ��ĳһ�����---����·
 * if--else if���������¼����ֳ�2�����ϵ������Ȼ������һ�ж�----����·
 * 
 * 
 * 
 * 
 * @author Administrator
 * 
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		/*
		 * - �ɼ����ڵ���90�֣�����
			- �ɼ����ڵ���80�֣�����
			- �ɼ����ڵ���60�֣�����
			- �ɼ�С��60�֣�������
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("��������ķ�����int����");
		int score=sc.nextInt();
		if(score>=90) {
			System.out.println("����");
		}else if(score>=80) {
			System.out.println("����");
		}else if(score>=60) {
			System.out.println("����");
		}else if(score<60) {
			System.out.println("������");
		}
		System.out.println("ʣ�����Ч����");
		System.out.println("----------------------------------------");
		//�޸ĳ���Ӧ��Ч��
		if(score<60) {
			System.out.println("������");
		}else if(score<80&&score>=60) {
			System.out.println("����");
		}else if(score<90&&score>=80) {
			System.out.println("����");
		}else if(score>=90) {
			System.out.println("����");
		}
		System.out.println("ʣ�����Ч����");
		
		
	}

}













































