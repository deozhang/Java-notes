package com.xms.basic.day07.p;
/**
 * ������
 * @author Administrator
 *
 */
public class TestTeacher {
	public static void main(String[] args) {
		//��������(ʵ����)--��ʦ����
		Teacher t=new Teacher();
		//��Ա������ֵ
		t.name="����";
		t.age=25;
		t.sex='��';
		//ȡֵ
		String name1=t.name;
		System.out.println("name1="+name1);
		double money1=t.money;
		System.out.println("money1="+money1);
		//���ó�Ա����
		t.teach();
		t.playGame();
		
		
	}

}



















