package com.xms.se.day02;

import java.util.Scanner;

public class Demo01String {
	public static void method1() {
		/*
		 * subString(int start,int end):
		 * ��ȡ�ַ���[start,end),����ֵΪ��ȡ���ַ���
		 */
		String str="0123456789";
		String s=str.substring(1,7);
		System.out.println(s);
		/*
		 * subString(int index);
		 * ��ȡ�ַ�������indexλ�ÿ�ʼ��ȡindex(index)λ��֮����ַ���
		 * ����ֵΪ��Ӧ���ַ���
		 */
		String s1=str.substring(4);
		System.out.println(s1);
		/*
		 * һ���ȡ����
		 * www.baidu.com
		 * --baidu
		 */
		String str1="www.baidu.com";
		String ss=str1.substring(str1.indexOf(".")+1,str1.lastIndexOf("."));
		System.out.println(ss);
	}
	
	public static void method2() {
		/*
		 * trim():ȥ���ַ������˿հ�
		 * ---����ȥ���м�Ŀհ�
		 */
		String str=" �й� ���� ";
		System.out.println(str);
		String s=str.trim();
		System.out.println(s);
	}
	
	public static void method3() {
		/*
		 * charAt(int index)��
		 * ����ֵΪ��Ӧλ���ϵ��ַ�
		 */
		String str="hello";
		char s=str.charAt(2);
		System.out.println(s);
	}
	
	public static void method4() {
		/*
		 * startsWith(String str):�Ƿ��Ը������ַ�����ͷ
		 * endsWith(String str):�Ƿ��Ը������ַ�����β
		 * ����ֵΪboolean����
		 * ��ָ���ַ���---true
		 * ����ָ���ַ���---false
		 */
		//�ж��ϴ����ļ��Ƿ���ָ�����ļ���ʽ��β.txt
		System.out.println("���ϴ��ļ���");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		if(str.endsWith("txt")) {
			System.out.println("�ļ���ʽ��ȷ");
		}else {
			System.out.println("�ļ���ʽ����");
		}
	}
	
	public static void method5() {
		/*
		 * toUpperCase():����ĸ�ַ���ת�ɴ�д
		 * toLowerCase():����ĸ�ַ���ת��Сд
		 * ����ֵΪת������ַ������� 
		 */
		String str1="abc";
		String str2="ABC";
		String s1=str1.toUpperCase();
		String s2=str2.toLowerCase();
		System.out.println("s1:"+s1);
		System.out.println("s2:"+s2);
		/*
		 * equalsIgnoreCase():
		 * ��������ĸ��Сд�Ƚ��ַ���
		 * ����ֵΪ��������
		 */
		if(str1.equals(str2)) {
			System.out.println("���ִ�Сд�Ƚ�");
		}else {
			System.out.println("�����ִ�Сд�Ƚ�");
		}
	}
	
	public static void method6() {
		/*
		 * String.valueOf(�������� i)
		 * ����������ת���ַ�������
		 * ����ֵΪ�ַ�������
		 */
		int i=23;
		System.out.println(i+2);
		String s=String.valueOf(i);
		System.out.println(s+2);
	}
	public static void main(String args[]) {
		method1();
		method2();
		method3();
		method4();
		method5();
		method6();
	}
}
