package com.xms.basic.day02;
/**
 * �߼��������
 * ���ţ�
 * 	&&(��)������ͬʱΪ�棬����������Ϊ�棬��һ��Ϊ�٣�������������Ϊ��
 * ||����:������һ��Ϊ�棬����������Ϊ�棬����ͬʱΪ�٣�������������Ϊ��
 * !(ȡ��):���������ʽ���߱���ȡ�෴�Ľ����true<--->false��
 * 1.�����߼�����ı������߱��ʽ��Ϊboolean����
 * 2.�߼�������Ľ��ҲΪboolean����
 * @author Administrator
 *
 */
public class Demo07 {
	public static void main(String[] args) {
		System.out.println("---------&&-----------------------------------------------");
		System.out.println(3>2&&3>2);//t
		System.out.println(3<2&&3<2);//f
		System.out.println(3>2&&3<2);//f
		System.out.println(true&&3<2);//f
		System.out.println("---------||-----------------------------------------------");
		System.out.println(3>2||3>2);//t
		System.out.println(3<2||3<2);//f
		System.out.println(3>2||3<2);//t
		System.out.println(true||3<2);//t
		System.out.println("---------!-----------------------------------------------");
		System.out.println(!(3>2||3>2));//f
		System.out.println(!true||3<2);//f
		System.out.println();
		
		/*
		 * &&��&��||��|����������������û�в�𣬲��ֻ����
		 *										 д���ϵĲ�ͬ��������ִ��Ч�ʲ�ͬ
		 */
		System.out.println("---------&-----------------------------------------------");
		System.out.println(3>2&3>2);//t
		
		System.out.println(3<2&&3<2);//f
		System.out.println(3<2&3<2);//f
		
		System.out.println(3>2&3<2);//f
		System.out.println(true&3<2);//f
		System.out.println("---------|-----------------------------------------------");
		System.out.println(3>2||3>2);//t
		System.out.println(3>2|3>2);//t
		
		System.out.println(3<2|3<2);//f
		
		System.out.println(3>2||3<2);//t
		System.out.println(3>2|3<2);//t
		
		System.out.println(true||3<2);//t
		System.out.println(true|3<2);//t
		
		
		
	}

}


















































