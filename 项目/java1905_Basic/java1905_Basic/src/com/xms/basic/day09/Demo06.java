package com.xms.basic.day09;
/**
 * final���δ�--���յ�
 * 
 * 1.���γ�Ա�����������γ�Ա�����󣬸ó�Ա���������ʼ�������ɸı�
 * 				--1.��������ͬʱ��ʼ��
 * 				--2.�ڹ��췽���г�ʼ��
 * 				 finalҲ�������ξֲ�����----��������
 * 		
 * 	2.���η�������final���εķ������÷������ܱ���д�������ܱ��̳У�
 * 		���壺ʹһ���������ܱ���д�����壬��ֹ�����ڶ��巽��ʱ�������⡱
 * 				  ��д�˸���ķ���
 * 3.�����ࣺ��final�����࣬���಻�ܱ��̳У����ǿ��Լ̳б���ࣨ������final���Σ�
 * 		���壺ʹһ�����ܼ̳е����壺��ֹ�̳е����ã���ϵͳ��ɵ��˺�
 * 
 * 
 * @author Administrator
 *
 */
public final class Demo06 {
//	String
//	Integer
	
	
	
	final int a;
//	final int a=10;//������ͬʱ��ʼ��
	
	public Demo06() {
		a=11;
	}
	
	public final void add() {
		System.out.println("Deno06-add()");
	}
	
	
	public static void main(String[] args) {
		Demo06 d=new Demo06();
//		Demo07 d1=new Demo07();
		
		
	}

}

//class Demo07 extends Demo06{
//	public  void add() {
//		System.out.println("Demo07-add()");
//	}
//}





























