package com.xms.se.day01;
/**
 * �����ַ������õķ���
 * @author Administrator
 *
 */
public class Demo03 {
	public static void method1() {
		String str="0123456789";
		/*
		 * length():��ȡ��ǰ�ַ�������ĳ��ȣ��ַ�������
		 * ����ֵΪ�������ͣ�int��
		 */
		int len=str.length();
		System.out.println(len);
	}
	
	public static void method2() {
		/**
		 * �ַ����ĵײ����ַ����飺�ַ������±��0��ʼ����length-1����
		 * �ַ����ķ���������������±꣺ǰ�����󲻰���eg: [0,100)
		 */
		/*
		 * indexOf(String str):
		 * ������ǰ�ַ�����ָ���ַ�����λ��
		 * ����ֵΪ�������ͣ�int��,�Ǹ��ַ������±�λ��
		 * 
		 * 1.����ƥ�䣬����ֵ�Ǵ���������ƥ�䵽���ַ����±�
		 * 2.���û��ƥ�䵽ָ���ַ������򷵻�ֵΪ-1;
		 */
		
		String str="good good study,day day up";
		int index1=str.indexOf("day");
		System.out.println(index1);
		int index2=str.indexOf("hello");
		System.out.println(index2);
		System.out.println("--------------------------------------------------");
		/*
		 * indexOf(String str,int index):
		 * �ڵ�ǰ�ַ������±�Ϊindexλ�ÿ�ʼ����str
		 * ����ֵΪint���͵��ַ����±�
		 */
		int index4=str.indexOf("d",4);
		System.out.println(index4);
		
		/*
		 * lastIndexOf(String str):
		 * ����ָ���ַ������һ�γ��ֵ�λ��
		 * ����ֵΪint���ͣ�Ϊ��Ӧ�ַ������±�
		 */
		int index5=str.lastIndexOf("good");
		System.out.println(index5);
		
		int index6=str.indexOf("good",str.indexOf("good")+1);//����Ƕ��ʹ��
		System.out.println(index6);
		
	}
	public static void main(String args[]) {
		method1();
		method2();
	}
}
