package com.xms.se.day08;
/**
 * finally:���յ�
 * 	��try-catchһ��ʹ��
 * 	��ʾ����try���д����Ƿ��쳣,finally�еĴ��붼�ᱻִ��
 * 
 * 	finallyͨ��������β���������
 * 	�ر���,�ر����ݿ�����...
 * 	
 * @author deo
 *
 */
public class Demo04Exception {
	public static void main(String[] args) {
		try {
			System.out.println("��������");
			System.out.println("�����ݿ⽨������");
			System.out.println("�������ݿ�������");
			System.out.println("��������");
			System.out.println("��������");
			
		} finally {
			System.out.println("�ر����ݿ�����");
		}
	}
}














