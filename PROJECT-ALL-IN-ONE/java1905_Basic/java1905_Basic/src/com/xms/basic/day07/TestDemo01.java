package com.xms.basic.day07;
/**
 * ������
 * @author Administrator
 *
 */
public class TestDemo01 {
	public static void main(String[] args) {
//		String name="����";
//		char sex='��';
//		int age=18;
//		long id=340406199908062418l;
//		Demo01.printInformation(name, sex, age, id);
//		System.out.println("--1-------------------------------------");
//		//�ö�����ݵ� ��������һ������---����
//		//����û�ж����ݽ���ͳһ�ķ�װ
//		String name1="11";
//		char sex1='?';
//		int age1=-20;
//		long id1=2;
//		Demo01.printInformation(name1, sex1, age1, id1);
		
		//��������---ʵ����
		/*
		 * ������������---�������ͱ���
		 * ������������---���ñ���
		 * 
		 * new ---ǿ�Ʋ�����һ������new�ؼ��֣��ͻ����ڴ��п��ٶ�Ӧ��
		 * 				�洢�ռ�
		 */
		int a=12;
		Human h=new Human();
		/*
		 * ȡֵ�͸�ֵͨ�����ñ���
		 */
		//��Ա�����ĳ�ʼ��---��ֵ
		h.name="����";
		h.sex='��';
		h.age=18;
		h.id=340406199908062418l;
		String name1=h.name;
		//ȡֵ
		System.out.println(name1);
//		Demo01.printInformation(h);
		
		//���ó�Ա����
		h.printInformation();
		
		
	}
}


































