package com.xms.se.day08;
/**
 * 	�׳���throws	�ڷ�������������ʾ�����ߣ��÷������ܻ�����쳣��
 * 	�õ����߽��д�����������
 * 		1.����
 * 		2.�׳�
 * 	throw���Զ����쳣
 * @author deo
 *
 */
public class Demo03Exception {
	public void method1() throws Exception {
		Student s=new Student();
		s.setAge(80);
		System.out.println(s.getAge());
	}
	public static void main(String[] args) {
		Demo03Exception de=new Demo03Exception();
		try {
			de.method1();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

//ѧ����
class Student{
	private String name;
	private int age;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws Exception {
		if(age<=0||age>=160) {
			/*
			 * 	RuntimeException:
			 *	�����Ĭ����Щ�쳣���ڳ���Ա��˵�ǳ�ʶ�Ե�
			 *	����Ҫ��ʾ��
			 */
			throw new RuntimeException("���䳬��������Χ");
		}
		this.age = age;
	}
	
}














