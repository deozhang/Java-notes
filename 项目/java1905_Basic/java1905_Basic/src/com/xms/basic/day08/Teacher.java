package com.xms.basic.day08;
/**
 * ��ʦ��
 * 
 * ���췽�����������󣬳�ʼ����Ա�����ķ���---֧�ַ���������
 * 		--��ͬ����ͨ����������Ҳ�Ƿ�������֧�ַ���������
 * 			1.�����������������ͬ
 * 			2.û�з���ֵ������Ҳ����дvoid
 * 			�﷨��
 * 					Ȩ�����η�  ����(){
 * 						........
 * 					}
 * 
 * 
 * this:----��ʾָ����ǰ���������
 * 			----�ڹ��췽���У����Ե���
 * 				  �������Ѿ����ڵ������Ĺ��췽��
 * 			----���ֹ��췽������ʽ�����ͳ�Ա����
 * 
 * 
 * ������
 * 		1.���ݴ洢λ�ã��ֲ������ͳ�Ա����
 * 			--1.�ֲ�����:
 * 						1.�����ڷ����У����������ж��壩
 * 						2.û�г�ʼֵ��ʹ��֮ǰ�����ʼ��
 * 						3.��������ʱ���洢��ջ֡�У��������ý�����ջ֡	
 * 							��ʧ���ֲ�����ʧЧ
 * 			--2.��Ա������		
 * 						1.���������У�������	
 * 						2.��Ĭ��ֵ��ʹ��֮ǰ�����Բ��ó�ʼ��
 * 						3.ʵ��������󣬴洢�ڶ��У�������ʧ��gc���գ���
 * 							��Ա����ʧЧ	
 * 						gc()---�������յķ������ػ��̣߳���̨�̣߳���
 * 						
 * 
 * 		2.�����������ͣ��������ͱ������������ͱ���
 * 						�������ͱ�������������������������
 * 						�������ͱ��������˰��ֻ����������ͱ���֮�������
 * 												�����ı���
 * 
 * �ڴ����
 * 		1.ջ��:�ֲ���������������ʱ�����ñ�������ֵַ�����Լ����÷���
 * 					ʱ�Ĳ���ֵ
 * 		2.�����������Ķ��󣬳�Ա����
 * 		3.�������������Ϣ���Լ���������̬������
 * 
 * @author Administrator
 *
 */
public class Teacher {
	//��Ա����
	String name;
	int age;
	char sex;
	double money;
	/*
	 * ���һ������û��д�κεĹ��췽������༭����
	 * �Զ�׷��һ���޲����Ĺ��췽����һ��д�빹�췽
	 * �����༭���򲻻���Ĭ��׷�޲����Ĺ��췽��
	 * 
	 * ---��ʹ�����޲����Ĺ��췽��������ֶ����룬��ֹ����
	 * 		���뱨��
	 */
	//�޲����Ĺ��췽��
	public Teacher() {
	
		System.out.println("�޲����Ĺ��췽��");
	}
	
	//�в����Ĺ��췽��
	public Teacher(String name,int age) {
		this.name=name;
		this.age=age;
		
	}
	//�в����Ĺ��췽��
	public Teacher(String name,int age,char sex) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		System.out.println("name��age,sex");
		
	}
	//�в����Ĺ��췽��
	public Teacher(String name,int age,char sex,double money) {
		//���ø��������������Ĺ��췽��
		//�����д�ڹ��췽���ĵ�һ��
		this(name,age,sex);
//		this.name=name;
//		this.age=age;
//		this.sex=sex;
//		this(money);//���뱨��
		this.money=money;
		System.out.println("name,age,sex,money");
	}
	
	public Teacher(double money) {
		this.money=money;
	}
	
	//��Ա����
	public void teach() {
		System.out.println("�Ͽ�");
//		System.out.println(a);
	}
	
	public void run() {
		int a=10;
		System.out.println(a);
		System.out.println("�˶�");
	}
	public static void main(String[] args) {
		Teacher t=new Teacher();
		t.run();
		t.teach();
	}
	
	

}
























