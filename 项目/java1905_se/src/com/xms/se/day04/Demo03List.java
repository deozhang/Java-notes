package com.xms.se.day04;

import java.util.*;

/**
 * List���ϣ�������ظ��ļ���
 * 				---Ԫ�صĴ洢����˳��ͨ���±����Ԫ�أ�
 * 				---������Դ���ظ���Ԫ��
 * 			ArrayList:����ṹ---����ʵ�ֵģ�Ԫ�صļ������ѯЧ�ʽϸߣ�
 * 					����������������ݽṹ����ʹ��һ���������ڴ�����洢����
 * 					�������ݵĸ����ڷ���ռ�ʱ���Ѿ�ȷ��
 * 			linkedList:����ṹ---����ʵ�ֵģ�Ԫ�صĲ����ɾ��Ч�ʽϸߣ�
 * 					�������ڷ��������ڴ浥Ԫ�б��棬����ͨ��ָ�뽫�����ڴ浥Ԫ
 *					������һ�������ǲ���Ҫ��ǰ����̶���С�Ĵ洢�ռ䣬����Ҫ
 *					�洢���ݵ�ʱ�򣬷���һ���ڴ潫���ݴ����ڴ��У���ָ�뽫�����
 *					��������
 *
 *					�ڵ�:��������ָ������
 *					������ǰѸ����ڵ�������
 * @author Administrator
 *
 */
public class Demo03List {
	public static void method1() {
		//����List����--���ͣ�String ��
		List<String> list=new ArrayList<String>();
		list.add("a");//0
		list.add("b");//1
		list.add("c");//2
		list.add("d");//3
		list.add("e");//4
		System.out.println(list);
		System.out.println(list.size());
		System.out.println("--s1---------------------");
		/*
		 * get(int index):index--��ʾ�±꣨0~size()-1��
		 * �÷���ͨ���±��ȡ��Ӧλ���ϵ�Ԫ��
		 * ����ֵΪ��Ӧ���Ϸ��ͣ����ϴ洢����ʲô���͵�Ԫ�أ�����ֵ����ʲô���ͣ�
		 * ע�⣺�±�Խ��
		 */
		String s1=list.get(0);
		System.out.println("s1:"+s1);
		//��ͳforѭ����������
		for(int i=0;i<list.size();i++) {
			String str=list.get(i);
			System.out.println(str);
		}
		System.out.println("--s2---------------------");
		
		/*
		 * set(int index,<T>t):
		 * ʹ��tԪ���滻��indexλ���ϵ�Ԫ��
		 * ����ֵΪ���滻����Ԫ��ֵ�����Ϸ��ͣ�
		 * 
		 */
		String s2=list.set(0, "A");
		System.out.println("s2:"+s2);
		System.out.println(list);
		System.out.println("--s3---------------------");
		
		/*
		 * add(int index,<T> t):
		 * ��������Ԫ��t�����뵽indexλ���ϣ�
		 * indexλ����ԭ�е�Ԫ�ؼ�����Ԫ����������ƶ�
		 * ----void
		 */
		list.add(1, "B");
		System.out.println(list);
		System.out.println("--s4---------------------");
		/*
		 * remove(int index):
		 * �Ƴ�ָ��λ���ϵ�Ԫ��ֵ
		 * ����ֵΪ��Ӧ���ͱ��Ƴ���Ԫ��
		 */
		String s3=list.remove(2);
		System.out.println("s3:"+s3);
		System.out.println(list);
		System.out.println("-------------------------");
		
	}
	public static void method2() {
		/*
		 * ����Ӽ�����������ԭ���϶�Ӧλ�� Ҳ�ᷢ���仯����ֵַ����ͬ�ģ�
		 */
		List<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<20;i++) {
			list.add(i);
		}
		System.out.println(list);
		System.out.println("-------------------------");
		List<Integer> listNew=list.subList(6, 17);
		System.out.println(listNew);
		System.out.println("-------------------------");
		//����ȡ���Ӽ�ÿ��Ԫ������ʮ��
		for(int i=0;i<listNew.size();i++) {
			listNew.set(i,listNew.get(i)*10);
		}
		System.out.println(listNew);
		System.out.println(list);
		
	}
	
	public static void method3() {
		/*
		 * ����������֮���ת��
		 * ����ת����
		 * 		1.toArray():��List����ת��ΪObject���͵�����---ʹ�ý���
		 * 		2.toArray(new ��������[length]):��List����ת���Զ������͵�����
		 * 				1.length�����������ԭ���ϴ�С������Ĳ��ֲ���null
		 * 				2.length�������С��ԭ���ϴ�С��ϵͳ���Լ�����һ����ԭ���ϴ�С��ȵĴ洢�ռ䣬����ʹ���û������
		 * 
		 */
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		//������ת������
		Object[] objArr=list.toArray();//��������
		Integer[] inArr=list.toArray(new Integer[2]);
		System.out.println(Arrays.toString(inArr));
		
		/*
		 * ����תList����   ͨ����תSet����  Set���ϲ����ظ�
		 * asList(����[] arr):
		 * ��ָ��������ת��List����
		 * ����ֵΪ��Ӧ���͵�List����
		 */
		String[] strArr=new String[] {"a","b","c","d"};
		//����ת����
		List<String> listOne=Arrays.asList(strArr);		
		/*
		 * ����ת�ɼ��Ϻ󣬲��ܸı�ü����е�Ԫ��
		 */
//		listOne.add("e");//��֧�ֵĲ���
		System.out.println(listOne);	
		
	}
	
	public static void method4() {
		/*
		 * ���ϵĸ���
		 * 
		 */
		String[] strArr=new String[] {"a","b","c","d"};
		//����ת����
		List<String> listOne=Arrays.asList(strArr);		
		List<String> listTwo=new ArrayList<String>();
		//1.������ת�ɵļ�����ӵ��½��ļ�����---��ʱ���Ըı��¼��ϵ�Ԫ��
		listTwo.addAll(listOne);
		listTwo.add("e");
		System.out.println(listTwo);
		//2.ʹ�ù��췽��
		List<String> listThree=new ArrayList<String>(listOne);
		listThree.remove(3);
		System.out.println(listThree);
	}
	
	
	public static void main(String args[]) {
//		method1();
//		method2();
//		method3();
		method4();
	}

}
