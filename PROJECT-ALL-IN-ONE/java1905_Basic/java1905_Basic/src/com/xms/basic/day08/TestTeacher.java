package com.xms.basic.day08;
/**
 * ������
 * @author Administrator
 *
 */
public class TestTeacher {
	public static void main(String[] args) {
		//������ʦ�����---ʵ���������ø����е��޲����Ĺ��췽����������
		Teacher t=new Teacher();
		//��ֵ
		t.name="����";
		//ȡֵ
		String name1=t.name;
		System.out.println(name1);
		System.out.println(t.age);
		//���ó�Ա����
		t.teach();
		System.out.println("///////////////////////////////////////////////////////");
		//�����в����Ĺ��췽��
		Teacher t1=new Teacher("zs",18);
		System.out.println(t1.name);
		System.out.println(t1.age);
		System.out.println(t1.money);
		
		System.out.println("//////////////////////////////////////////////");
		Teacher t2=new Teacher("zs", 18, '��', 5);
//		Teacher t3=new Teacher("zs"��;
//		System.gc();
		
	}
	

}
