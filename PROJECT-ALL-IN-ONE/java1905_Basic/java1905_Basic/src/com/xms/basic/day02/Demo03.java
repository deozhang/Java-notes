package com.xms.basic.day02;
/**
 * ������������֮���ת��
 * ��С����֮��Ĺ�ϵ���£�
 * java�й涨��������ҪС�ڸ�������
 * byte-->short(char)-->int-->long-->float--->double
 * 1.�Զ�����ת��
 * 2.ǿ������ת��
 * @author Administrator
 *
 */
public class Demo03 {
	//������ڣ�main������
	public static void main(String[] args) {
		/*
		 * �Զ�����ת������С����ת������͵Ĺ��̣�С---->��
		 */
		//����������
		byte a=12;
		int a1=a;
		System.out.println("a1="+a1);
		//�����븡��
		//����ת�ɸ������ͻ���Ͼ���
		int b=12;
		double b1=b;
		System.out.println("b1="+b1);
		double b2=12;
		//�������ַ�
		char c='��';
		char c0='\u4e2d';
		int c1=c;
		int c2=c0;
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		/*
		 * ǿ������ת�����Ӵ�����תС���͵Ĺ��̣���-->С��
		 * 							--�������
		 * �﷨��С���� ������=��С���ͣ������ͱ���/������
		 */
		//�����븡��
		double d=12.5;
		int d1=(int)d;
		System.out.println("d1="+d1);
		//����������
		int e=129;
		byte e1=(byte)e;
		System.out.println("e1="+e1);
		//�������ַ�
		char f='��';
		int f1=f;
		int f2='��';
		System.out.println("f1="+f1);
		System.out.println("f2="+f2);
		
		int g=20013;
		char g1=(char)g;
		System.out.println("g1="+g1);
		
		char g2=20013;
		System.out.println("g2="+g2);
		
		
		
		
		
	}
	

}






















































