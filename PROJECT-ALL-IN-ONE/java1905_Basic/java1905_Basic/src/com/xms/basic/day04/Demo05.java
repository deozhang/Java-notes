package com.xms.basic.day04;
/**
 * while��do-while��ʹ��ע���������
 * 1.��ѭ��
 * 2.��break�ؼ��ִ���--��������ĳЩ����ǿ��������ǰѭ��
 * 3.while��do-while��ִ��ѭ��ʱ���ж�������һ��Ϊfalse��
 * 		ִ�д���
 * 		while:һ�ζ�����ִ��
 * 		do-while:����ִ��һ��
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		/*
		 * �������1~10
		 */
		int i=1;
		while(i<=10) {
			System.out.println(i);
			if(i==5) {
				break;
			}
			i++;
		}
		System.out.println("ʣ����Ч����");
	}

}


























