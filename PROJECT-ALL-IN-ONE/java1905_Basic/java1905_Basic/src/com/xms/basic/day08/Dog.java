package com.xms.basic.day08;
/**
 * ����
 * @author Administrator
 *
 */
public class Dog extends Animal  {
	//��Ա����
	int noseColor;//���ӵ���ɫ--�������е�����
	
	public Dog() {
		/*
		 * ֻ��д�ڸ��๹�췽���ĵ�һ��
		 */
		super();
		
	}
	
	public Dog(String name) {
		super();
		this.name=name;
	}
	
	public Dog(String name,int age,int noseColor) {
//		super();
//		this.name=name;
		this(name);
		this.age=age;
		this.noseColor=noseColor;
		
	}
	public Dog(String name,int age,char sex,int noseColor) {
//		super();//���ø����е��޲����Ĺ��췽��
		super(name,age,sex);//���ø����е��в����Ĺ��췽��
//		this.name=name;
//		this.age=age;
//		this.sex=sex;
		this.noseColor=noseColor;
		System.out.println("Dog");
		
	}
	
	public void play() {
		System.out.println(this.name);//����
		System.out.println(this.noseColor);//����
		
		System.out.println(super.name);//����
//		System.out.println(super.noseColor);//����
	}
	
	
	
	public void method1() {
		this.play();//����
		this.work();//����
		
		super.work();//����
		
	}
	
	public void work() {
		System.out.println("����");
	}
//	private void work1() {
//		System.out.println("����1");
//	}
	
//	private void eat() {
//		System.out.println("�Է�");
//	}

	//������д��̬����
	public static  void add() {
		System.out.println("son--add");
	}
	
	
	
	
	
	
	
	
	

}
