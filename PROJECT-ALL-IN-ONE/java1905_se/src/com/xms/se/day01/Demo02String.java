package com.xms.se.day01;
/**
 * char a='a';
 * char b='b';
 * 
 * char[] arr=new char[] {a,b}; 
 * 
 * �ַ������췽����
 * 1.public String() �޲ι��췽��
 * 	String str=new String();<===>String str="";
 * 
 * 2.public String(byte[] byte):
 * ���ֽ�����ת���ַ�������
 * 
 * 3.public String(byte[] byte,int index,int length):
 * ��ָ�����ֽ����飬��ָ�����±꿪ʼת���ַ���������length���ֽ�
 * 
 * 4.public String(char[] ch):
 * ��ָ�����ַ�����ת���ַ�������
 * 
 * 5.public String(char[] ch,int index,int length):
 * ��ָ�����ַ����飬��ָ�����±꿪ʼת���ַ���������length���ֽ�
 * 
 * 6.public String(String str):
 * ���ַ�������ת���ַ�������
 * 
 * 
 * 
 * String:�ַ�������--������������
 * --�ײ㣺�ַ�����
 * 1.�ַ�����������abc�������Կ���һ���ַ�������
 * 2.�ַ����������ǳ�����һ�����壬���ɸ���
 * 
 * 
 * @author Administrator
 *
 */
public class Demo02String {
	public static void method1() {
		//�����ַ�������
		String str=new String();
		//�����ַ�������--������ Ψһ�Ŀ���ʹ����������ʽ���������������������
		String str1="";
	}
	
	public static void method2() {
		//���ֽ�����ת���ַ�������
		byte[] by=new byte[] {97,98,99,100};
		String str1=new String(by);
		System.out.println(str1);
		String str2=new String(by,1,3);
		System.out.println(str2);
		
		char[] ch=new char[] {'a','b','c','d'};
		String str3=new String(ch);
		System.out.println(str3);
		String str4=new String(ch,1,3);
		System.out.println(str4);
	}
	
	public static void method3() {
		String str1="abc";
		String str2="abc";
		String str3=new String("abc");
		String str4=new String("abc");
		/*
		 * ==��equals�����𣨶���boolean���ͽ����
		 * 		1.==��
		 * 			�������ͣ��Ƚ�ֵ�Ĵ�С�Ƿ����
		 * 			�������ͣ��Ƚϵ�ֵַ���Ƿ����
		 * 		2.equals():
		 * 			String��
		 * 			�Ѿ���дequals����������ֻҪ�����ַ�����������ݡ���ȡ���
		 * 			�ͷ���һ��true�����򷵻�false
		 * 		
		 */
		/*
		 * �����أ���ʡ�ռ���Դ
		 * 
		 * ʹ����������������ʱ���������ڶ��е��ַ�����������Ѱ����ö��������Ƿ�һ����
		 * ���һ�������ַ����ڳ����صĵ�ֱַ�Ӹ�ֵ����Ҫ���������ݵı��������û�У�
		 * �����ַ��������ش��������ݣ�������ַ��ֵ��������
		 * 
		 * new�ؼ��ִ����ַ���������һ��ǿ���Բ�������ǿ���ڶ��ڴ��п��ٿռ�洢����
		 * 		1.��������û�и����ݣ�����ڳ������к��ڳ�����֮��Ķ��ڴ��д���������
		 * 		�����ñ�����ָ��new�ؼ��ֿ��ٵ��ڴ��ַ
		 * 		2.���������и����ݣ���ֱ���ڶ��ڴ��п��ٿռ�洢������
		 */
		
		
	}
	
	public static void method4() {
		String str1="";//�е�ַ ֵ�ǿյ�
		String str2=" ";//�е�ַ ֵ�ǿո�
		String str3=null;//û�е�ַ
		System.out.println(str1.equals(""));//true
		System.out.println(str2.equals(""));//false
		System.out.println(str3.equals(""));//�׳��쳣
		/*
		 * NullPointerException:��ָ���쳣
		 * 
		 */		
	}
	
	public static void method5() {
		/*
		 * �༭�����ԣ���һ�����ʱ���߶���������ʱ���༭����ֱ�ӽ����ʱ��������ڸ�λ��
		 * Ŀ���Ǽ������㿪��
		 */
		String s1="1234";//һ������
		String s2="123"+"4";//һ������1234��
		String s3="123";//һ������
		String s4=s3+"4";//��������
		
	}
	public static void main(String args[]) {
		method2();
		method3();
		method4();
	}

}
