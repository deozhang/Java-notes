package com.xms.se.day02;
/**
 * Object�������������͵Ķ������ࣨ��װ�ಿ�ֳ��⣩
 * �ñ��������ñ�������ָ���κ����͵Ķ���
 * û�г�Ա����  ���в��ַ���
 * --toString():����һ�����һ���������Ϣ�ķ�����ֻ����Ϊչʾ����ʹ��
 * ��д������ҵ��������д����  ������Ϊһ���Ƚϳ��õĵ��Թ���
 * --equals():�Ƚϸ������͵��������������Ƿ���ͬ
 * 		�������͵Ķ���ʱ�����໥�Ƚϣ�����һ����˵�����ǻ����ʵ�����������������ͬ���͵Ĳ�ͬ����
 * 		�Ƚϵ����
 * 
 * 		��д������ͬһ���͵Ĳ�ͬ�����ĳЩ����ֵ��ͬ
 * 				������Ϊ������������ͬ��
 *  
 * 
 *
 * �������:
 * 
 * 
 * @author Administrator
 *
 */
public class Demo05Object {
	public static void main(String args[]) {
		Student st1=new Student("xiaohong",15,2422);
		Student st2=new Student("xiaohong",15,2422);
		System.out.println(st1.toString());
	}
	

}
//ѧ����
class Student{
	String name;
	int age;
	int id;
	public Student() {
		
	}
	
	public Student(String name,int age,int id) {
		this.name=name;
		this.age=age;
		this.id=id;
	}
	
	@Override
	public String toString() {
		return "name:"+name+",age:"+age+",id:"+id;
	}
}