package com.xms.se.day04;

import java.util.*;

/**
 * һ��ʹ�ü���--ʹ�ö�̬�ı�ռ��С������
 *	�������õ����Ͷ���������--��������˼��Ϸ���
 * ���Ϸ��� jdk1.5֮��ʼ֧��
 * ��Ҫ�����Ƽ���Ԫ�ص�����
 * ������ڶ�Ԫ�ؽ���ͳһ����
 * 
 * 
 * ���м��϶�֧�ַ���
 * ������Ҳ֧�ַ���
 * 
 * 
 * @author Administrator
 *
 */
public class Demo02Collection {
	public static void method1() {
		//����Ӧ�ļ�����ӷ���---<������������>
		//ע��ǰ��������һ��
		Collection<Integer> c=new ArrayList<Integer>();
//		c.add("a");
		c.add(1);
//		c.add(new Student("zs",18));
		//1.��ȡ����������
		//����������ͨ����Ҫ�����ļ��Ϸ���һ��
		Iterator<Integer> i=c.iterator();
		//2.��
		while(i.hasNext()) {
			//3.ȡ
			Integer o=i.next();
			//
//			if(o instanceof Student) {
//				Student s=(Student)o;
//				
//				System.out.println(s.name);
//			}
			System.out.println(o);
		}

	}
	
	public static void main(String args[]) {
		method1();
	}
}








































