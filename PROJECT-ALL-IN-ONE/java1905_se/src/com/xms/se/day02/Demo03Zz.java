package com.xms.se.day02;

import java.util.Scanner;

/**
 * ������ʽ����������java�����ʹ��
 * ---���Ϊ����
 * ---��Ҫ��������֤�ַ����ĸ�ʽ
 * ---matches(String regex):ȫƥ��
 * 		�жϵ�ǰ�ַ��������Ƿ�����ָ���������ʽ
 * 		����ֵΪ��������
 * 		--��ʽ���ϣ�true
 * 		--��ʽ�����ϣ�false
 * 
 * 
 * @author Administrator
 *
 */
public class Demo03Zz {
	public static void method1() {
		Scanner sc=new Scanner(System.in);
		System.out.println("�������ַ�����");
		String line=sc.nextLine();
		String regex="[a-z&&^bz]";
		if(line.matches(regex)) {
			System.out.println("��ʽ��ȷ");
		}else {
			System.out.println("��ʽ����ȷ"); 
		}
	}
	
	public static void method3() {
		//�绰���� 1�����Ǹ�����
		String regex1="[1]\\d{10}";
		String s1="15555127212";
		System.out.println(s1.matches(regex1));
		System.out.println("---------------------------------");
		//���֤����
		//ǰ��λ���� ��� �·� �� ��λ����
		String regex2="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
		String regex3="^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{4}$";
		String regex4="\\w{4,}@\\w{2,5}(.com|.cn";
	}
	
	public static void method4() {
		/*
		 * replaceAll(String regex,String str):
		 * ����ǰ�ַ�������������ʽregex��ʾ���ַ����滻��str
		 * ����ֵΪ���滻����ַ�������
		 */
		//�����������滻�ɣ�
		String str="aaa12345bbb4567cccc1dddd";
		String regex="\\d";
		String s1=str.replaceAll(regex,"!");
		System.out.println(s1);
		String regex1="\\d+";
		String s2=str.replaceAll(regex1, "!");
		System.out.println(s2);
		System.out.println("-----------------------------------");
		/*
		 * spilt(String regex):
		 * �����ַ���������ָ����������ʽ�ָ�
		 * ����ֵΪ�ַ�������
		 */
		//[aaa,bbb,cccc,dddd]
		String regex2="\\d+";

	}
	public static void main(String args[]) {
//		method1();
//		method3();
		method4();
	}
}
