package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ������ʵ����:
 * 		������--�߼���
 * 		ObjectInputStream:����������
 * 			--readObject()
 * 		ObjectOutputStream:���������
 * 			--writeObject()
 * 
 * 1.���ض��ṹ������ת��һ���ֽڵĹ���--���л�
 * 2.������д�뵽�����ڴ��б���Ĺ���--�־û�
 * 3.���ֽ�ת���ض��Ľṹ���ݵĹ���--�����л�
 * 
 * ���л��ͷ����л�����:
 * 1.���ݵĴ���
 * 2.���ݵı���
 * 
 * {@link Serializable}�����л��Ľӿ�
 * ���һ����Ķ���,��Ҫ�������л�,������Ҫʵ�ֿ����л��Ľӿ�,
 * ��ʱ����Ķ���,�����ʸ�������л�
 * java.io.NotSerializableException:δʵ�����л��Ľӿ�
 * 
 * transient:���γ�Ա����,�����л�ʱ���Ըó�Ա������ֵ
 * (û�н������ݱ��浽Ŀ���ļ��� )
 * @author deo
 *
 */
public class Demo05Object {
	public static void method1() throws Throwable {
		/*
		 * ���л�
		 */
		//�ͼ���
		FileOutputStream fos=new FileOutputStream("stu.txt");
		//�߼���--������
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		Student s=new Student("zd",18);
		/*
		 * writeObject(Object obj):
		 * ����ObjectOutputStream���еķ���
		 * �÷������Խ��������Ŷ���ת��һ���ֽ�д�뵽Ŀ���ļ���
		 */
		oos.writeObject(s);
		oos.close();
		System.out.println("���л����");
	}
	public static void method2() throws Throwable {
		/*
		 * �����л�
		 */
		//�ͼ���
		FileInputStream fis=new FileInputStream("stu.txt");
		//�߼���--������
		ObjectInputStream ois=new ObjectInputStream(fis);
		/*
		 * readObject():
		 * ����ObjectInputStream���еķ���
		 * �÷������Զ�ȡһ������,����ֵΪObject���͵�����
		 * 
		 * ��Ҫǿ������ת��,���ܻ�ȡ��Ӧ���������
		 */
		Object obj=ois.readObject();
		if(obj instanceof Student) {
			Student s=(Student)obj;
			System.out.println(s.name);
			System.out.println(s.age);
		}
		System.out.println(obj);
		ois.close();
		System.out.println("�����л����");
	}
	
	
	public static void main(String[] args) throws Throwable {
//		method1();
		method2();
	}
}
//ѧ����
class Student implements Serializable{
	/**
	 * �汾��:IDE�Զ�����
	 * ��ֹ�����л���,�����л�ǰ,�����������,�����쳣,ʹ��IDE�Զ�����
	 * ���л��İ汾��
	 * 
	 * ��Ҫ�����л�֮ǰ����汾��
	 */
	private static final long serialVersionUID = 1L;
	String name;
	transient int age;//�����л�ʱ���Ըó�Ա������ֵ
	char sex;//����
	public Student() {
		
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
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}	
}