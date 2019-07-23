package com.xms.se.day02;
/**
 * �ɱ��ַ����е���
 * StringBuilder:�̲߳���ȫ����������Ч�ʽϸ�
 * StringBuffer:�̰߳�ȫ��ͬ������Ч�ʽϵ�
 * 
 * �������еķ���һ�£��÷�һ��
 * ͨ������������Զ��ַ��������޸�
 * 		--׷�ӣ�ɾ�����滻�����룬��ת
 * 		--����ֵΪ��ǰ���͵ĵ�ǰ����
 * 			������һ�������Ͻ����������޸ģ�������ַ������ݵĲ���
 * @author Administrator
 *
 */
public class Demo02StringBuilder {
	public static void  method1() {
		//����һ���ɱ��ַ����ж���
		StringBuffer sb=new StringBuffer();//�޲�
		StringBuffer sb1=new StringBuffer("abc");//�в�
		
		/*
		 * append(String str):
		 * ׷��ָ�����ַ���
		 * ����ֵΪ��ǰ���͵ĵ�ǰ����
		 */
		sb.append("hello");
		System.out.println(sb);
		sb.append("world");
		System.out.println(sb);
		
		/*
		 * delete(int start,int end):
		 * ɾ��ָ����Χ�ڵ��ַ���--ǰ�����󲻰���
		 * ����ֵΪ��ǰ���͵õ�ǰ����
		 */
		sb.delete(8, 10);//ɾ��ld
		//sb.delete(8, 11);   Ч��һ���� ���ǽ�ȡ�����һλ     
		System.out.println(sb);
		
		/*
		 * replace(int start,int end,String str):
		 *	��ָ�������ڵ��ַ����滻��ָ���ַ�����str��
		 *	����ֵΪ��ǰ���͵ĵ�ǰ����
		 */
		//hellowor --->javawor
		sb.replace(0,5,"java");
		System.out.println(sb);
		
		/*
		 * insert(int index,String str):
		 * ��ָ����λ�ò���ָ�����ַ�������λ�ü�������ַ�һ������ƶ�
		 * ����ֵΪ��ǰ���͵ĵ�ǰ����
		 */
		//javawor --->java!wor
		sb.insert(4, "!");
		System.out.println(sb);
		
		/*
		 * reverse():
		 * ����ǰ�ɱ��ַ������е��ַ�����ת
		 * ����ֵΪ��ǰ���͵ĵ�ǰ����
		 */
		//java!wor --->row!avaj
		sb.reverse();
		System.out.println(sb);
		
		
	}
	
	//��һ����������������޸�
	public static void method2() {
		StringBuilder sb=new StringBuilder();
		sb.append("hello").append("world").delete(8, 10).replace(0,5,"java").insert(4,"!").reverse();
		System.out.println(sb);
	}
	public static void main(String args[]) {
		method1();
		method2();
	}
}
