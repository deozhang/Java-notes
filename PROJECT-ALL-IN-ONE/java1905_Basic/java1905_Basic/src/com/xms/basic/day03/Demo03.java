package com.xms.basic.day03;

import java.util.Scanner;

/**
 * ��֧���:
 * 			if-else:����ĳЩ����ִ��ĳЩ��䣬������ĳЩ����
 * 						ִ������ĳЩ���
 * 		�﷨��
 * 				if(�������ͱ��ʽ){
 * 					�߼����1
 * 				}else{
 * 					�߼����2
 * 				}
 * 				ʣ�����
 * 		ִ�����̣������жϲ������ʽ������������ʽΪtrue,��ִ��if
 * 						�������е��߼���䣬����������ͱ��ʽΪfalse,��ִ
 * 						��else���ŵ��߼���䣬����ִ������֮һ������if-else
 * 						����ִ��ʣ����Ч����
 * 
 * 
 * @author Administrator
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		/*
		 * �ж�һ��int���͵����֣��Ǵ���0 ����С�ڵ���0������
		 */
		//��ȡ��������Ĺ�����
		Scanner sc=new Scanner(System.in);
		System.out.println("������int���͵����֣�");
		//���û�ȡ�������ֵķ����������ݻ�ȡ�����Ҹ�ֵ����Ӧ���͵ı���
		int num=sc.nextInt();
		if(num>0) {
			System.out.println("����һ������0��int���͵�����");
		}else {
			System.out.println("����һ��С�ڵ���0��int���͵�����");
			
		}
		System.out.println("ʣ����Ч����");
	}

}













































