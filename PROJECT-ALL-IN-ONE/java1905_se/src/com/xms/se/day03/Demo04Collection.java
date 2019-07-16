package com.xms.se.day03;

import java.util.*;


/**
 * java�ڲ��������ṩ�˼����࣬�����ʵ�����Դ洢�κ����͵Ķ��󣬴洢�ռ�Ĵ�С
 * ���Զ�̬�ı䣬����Ԫ�ص��������������С
 * 
 * ���ϵ�������
 * 		���飺����һ�����岻�ɸ��ģ���Ԫ�س����˶���Ŀռ��С������Ҫ���¶�������
 * 				ֻ�ܴ洢��ͬ���͵�Ԫ��
 * 		���ϣ��µ����ݽṹ�����Ա��治ͬ���͵�Ԫ�أ��ҿռ��С���Զ�̬������
 * 
 * �����뼯�ϵ�����
 * 				1.���ݼȿ��Դ洢�������͵����ݣ�Ҳ���Դ洢�������͵�����
 * 					������������洢����ֵ��������������洢���ǵ�ֵַ
 * 				2.����ֻ�ܴ洢�������͵����ݣ��洢���ǵ�ֵַ
 * 				3.����ĳ����Ƕ��������ܶ�̬����
 * 				  ���ϵĳ����ǲ����ģ���������Ԫ�ظı������
 * 
 * Ӧ�ó�����
 * 		1.�����������һ���ģ��Ƽ�ʹ������
 * 		2.����������ǲ����ģ��Ƽ�ʹ�ü���
 * 
 * ���ϵļ̳���ϵ��
 * 		���ӿ�--Collection��
 * 			�ӽӿڣ�
 * 			List(list����):--���򼯺ϣ����ظ�����ȡ���ǰ���˳������
 * 				ʵ���ࣺ
 * 				Arraylist:����ṹ
 * 				LinkedList:����ṹ
 * 			Set(set����):--���򼯺ϣ��������򣩣������ظ�����ȡû��˳��
 * 				ʵ���ࣺ
 * 				HashSet:��ϣ�㷨
 * 				TreeSet:�������㷨
 * ���ϵĻ�������
 * 			boolean add(E e):���һ��Ԫ�ص�������
 * 			boolean remove(Object o):ɾ��һ��Ԫ�ص�������
 * 			boolean contains(Object o):�жϼ������Ƿ����ָ��Ԫ��
 * 			boolean isEmpty():�жϼ����ǲ��ǿ�
 * 			int size():��ȡ���ϵĴ�С
 * 			void clear():��������գ�ȫ��ɾ����
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo04Collection {
	public static void method1() {
		//��������ʵ��
		Collection c=new ArrayList();
		//�򼯺������Ԫ��---������ֻ�洢������������
		c.add("a");//��������
		c.add("b");//��������
		c.add(1);//�Զ�װ��---��������
		c.add(2);//�Զ�װ��---��������
		c.add(1);//�Զ�װ��---��������
		c.add(4);//�Զ�װ��---��������
		
		System.out.println(c);
		System.out.println("���ϵĴ�С��"+c.size());//��ȡ���ϵĴ�С
		
		/*
		 * remove(Object o):
		 * ����ֵΪboolean����
		 * true��
		 * false:
		 * ɾ��������ָ����Ԫ�أ�ɾ�����Ǵ�ͷ��β����ƥ�䵽������
		 * �ж���ͬʹ�õķ���Ϊequals()
		 * ����ֵΪtrueʱ�Ƴ�Ԫ��
		 */
		
		//�����в����ڵ�
		boolean bo1=c.remove(6);
		System.out.println("bo1:"+bo1);
		boolean bo2=c.remove(1);
		System.out.println("bo2:"+bo2);
		System.out.println(c);
		
		/*
		 * contains(Object o):
		 * �жϼ������Ƿ����ָ��Ԫ��
		 * ����ֵΪ�������ͣ�����ֵΪtrue ����
		 * 
		 * �ж��Ƿ����ʹ��equals����
		 * ��������true �������ͷ���false
		 */
		boolean bo4=c.contains("a");
		System.out.println("bo4:"+bo4);
		boolean bo5=c.contains("c");
		System.out.println("bo5:"+bo5);
		
		/*
		 * isEmpty():
		 * �ж�һ�������ǲ��� ��
		 * ����ǿգ�����true�����Ƿ���false
		 * 
		 * clear():
		 * �����Ͻ��������ɾ������Ԫ�أ�
		 * �޷���ֵ
		 */
		boolean bo6=c.isEmpty();
		System.out.println("bo6:"+bo6);
		c.clear();
		boolean bo7=c.isEmpty();
		System.out.println("bo7:"+bo7);
		
	}
	
	public static void method2() {
		/**
		 * ���ϵ���������
		 * 		boolean addAll(Collection c):���һ������
		 * 		boolean removeAll(Collection c):ɾ��һ������
		 * 		boolean containsAll(Collection c):�Ƿ����ָ������
		 * 		
		 */
		Collection c1=new ArrayList();
		c1.add(1);
		c1.add(2);
		Collection c2=new ArrayList();
		c2.add(3);
		c2.add(4);
		Collection c3=new ArrayList();
		c3.add(5);
		c3.add(6);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//��c2��ӵ�c1��
		c1.addAll(c2);//���д��add   ���ɶ�ά����
		System.out.println("--------------------------");
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		//�ж�c1�������Ƿ����c2   c1��Ҫ����c2������Ԫ�ز������
		boolean bo1=c1.containsAll(c2);
		boolean bo2=c1.containsAll(c3);
		System.out.println("--------------------------");
		System.out.println("bo1:"+bo1);
		System.out.println("bo2:"+bo2);
		
		//ɾ��һ������ 
		/*
		 * ����ֵΪ��������,
		 * �������ֵΪtrue����ʾɾ���ɹ�
		 * �������ֵΪfalse����ʾɾ��ʧ��
		 * 
		 */
		boolean bo3=c1.removeAll(c2);
		boolean bo4=c1.removeAll(c3);
		System.out.println("--------------------------");
		System.out.println("bo3:"+bo3);
		System.out.println("bo4:"+bo4);
		
		
	}
	public static void main(String args[]) {
//		method1();
		method2();
	}
}
