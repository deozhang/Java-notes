package com.xms.se.day04;

import java.util.*;

/**
 * ���ϵı���
 * 		1.����������
 * 		2.��ǿ��forѭ��
 * 
 * @author Administrator
 *
 */
public class Demo01Collection {
	public static void method1() {
	/**
	 * 1.������������	Iterartor�ӿ�
	 * javaϣ������ʹ��ͳһ�ķ�ʽ �������ϣ���˶�����
	 * �������ϵĽӿڣ��ҹ涨��ʹ�õ������������ϵĲ���
	 * 		1.��ȡ����������
	 * 		2.�ж�ָ���Ƿ���Ԫ��
	 * 		3.�����Ԫ�أ���ȡ��Ԫ��
	 * 
	 * 		4.ɾ��----���п���
	 * 
	 * 
	 */
		Collection c=new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		c.add(1);
		
		//1.��ȡ����������
		Iterator i=c.iterator();
		//2.�ж��Ƿ���Ԫ��-- ��
		/*
		 * hasNext():�жϵ�ǰָ���Ƿ�ָ��ĳ��Ԫ�أ����ָ���򷵻�true,
		 * ���ָ��Ϊ��
		 * �򷵻�ֵΪfalse
		 * 
		 */
		
		while(i.hasNext()) {
			Object o=i.next();
			/*
			 * �ڵ������������Ϲ�����
			 * �����Ҫɾ��ĳ�����ڱ�����ĳ��Ԫ��
			 * ��Ҫʹ�õ������ı�������
			 * 
			 */
			System.out.println(o);
		}
		
	}
	
	public static void method2() {
		/**
		 * 2.��ǿ��forѭ��
		 * ʹ����ǿ��forѭ����������
		 * java 5.0���ֵ������ԣ���ѭ����ͨ���ڴ�ͳ
		 * forѭ�����书��ֻ���ڱ������Ϻ�����
		 * �﷨��
		 * 		for(Ԫ������ Ԫ����:����/������){
		 * 		��������
		 * 		}
		 * 
		 * �����ǵ�����
		 * for eachѭ�������µ��﷨�����ĵײ��ǵ������﷨
		 * ��˱����Ĺ����в���ʹ�ü���ɾ��Ԫ�صķ���
		 * 
		 * 
		 */
		Collection c=new ArrayList();
		c.add("a");
		c.add("b");
		c.add("c");
		c.add("d");
		c.add(1);
	}
	
	public static void main(String args[]) {
		method1();
	}
}
//ѧ����
class Student{
	String name;
	int age;
	
	public Student() {
		
	}
	public Student(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
}
