package com.xms.basic.day02;
/***
 * ���ӷ���"+"
 * 		����ʵ���ַ���֮�����ӣ�Ҳ����ʵ���ַ����������������͵�����
 * ע�⣺
 *	�ַ���ʹ�����ӷ����κ��������ͽ������ӣ����յ����ݵ����Ͷ�Ϊ
 *	�ַ�������
 * @author Administrator
 *
 */
public class Demo08 {
	public static void main(String[] args) {
		//�ַ������ַ���֮�������
		String str1="����";
		String str2="��ӭ��";
		String str3=str1+str2;
		System.out.println(str3);
		//�ַ����������������͵�����
		int age=12;
		String str="����:"+age;
		System.out.println("���䣺"+age);
		
		String s=""+100+200;//"100"+200//"100200"
		String s1=""+(100+200);//"100"+200//"100200"
		System.out.println(s);
		System.out.println(s1);
		
	}

}
