package com.xms.basic.day03;
/**
 * ��ʾ�������㣨��Ŀ���㣩��
 * 		�﷨�ṹ��
 * 				���ʽ���������ͱ��ʽ�������ʽ1�����ʽ2��
 * 		ִ������:
 * 				�����жϲ������ͱ��ʽ������������ͱ��ʽΪ
 * 				true,��ִ�б��ʽ1������������ͱ��ʽΪfalse
 * 				��ִ�б��ʽ2��ִ����󣬳������
 * 		ע�⣺
 * 				1.���ʽ1�ͱ��ʽ2���Ծ���ֵ��ͬʱ��Ҫ��������
 * 					��ʽ����һ�£��Զ�ת�����⣩
 * 				2.�����������Ƕ��ʹ��
 * 			
 * @author Administrator
 *
 */
public class Demo01 {
	//�������ڣ�main������
	public static void main(String[] args) {
		int a0=3<2?1:3;
		System.out.println("a0="+a0);
		
		/*
		 * int a=1;
		 * int b=2;
		 * int c=3;
		 *Ҫ��a<b��a<cʱ�����true��,���������false��
		 */
		int a=1;
		int b=2;
		int c=3;
		String str=a<b&&a<c?"true":"false";
		System.out.println("str="+str);
		//��Ŀ�����Ƕ��
		String str1=a<b?a<c?"true":"false":"false";
		System.out.println("str1="+str1);
		
		
	}

}



















































