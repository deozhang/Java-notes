package com.xms.basic.day10.Demo04;
/**
 * �ڲ���:һ������Զ���������һ�����У��ⲿ����
 * 				�����ⲿ�࣬�ڲ���������ڲ���
 * 
 * 				�ڲ��ඨ�����ⲿ�࣬ͨ��ֻ�������ⲿ�࣬���ⲿ���������ǲ��ɼ�
 * 				�ģ��ڲ�����Ե����ⲿ�����Ա�����ͷ���������˽�еģ�
 * 
 * �����ڲ��ࣺû�����ֵ��ڲ���
 * 						�����һ�γ�����Ҫ����ĳһ�����͵Ķ��󣬶���ֻ
 * 						������һ�����󣬸���Ͳ���ʹ�ã���ʱ������Բ�
 * 						����������Ҫʹ�������ڲ���
 * 						ע�⣺������Ҫ��Ҫ�̳�ĳ�������ʵ��ĳ���ӿ�
 * 	һ���ļ����м���class�ؼ��֣��ͻ����ɼ���.class�ļ�
 * �����Ҳ��������ڲ�����������Ӧ��������.class�ļ���
 * 
 * @author Administrator
 *
 */
public class Outer {//�ⲿ��
	//��Ա����
	int a;
	private int b;
	
	//1.����һ���ڲ������͵ı���
	Inter i;
	
	public Outer() {
		i=new Inter();
	}
	
	//��Ա����
	public void methodOuter() {
		System.out.println("methodOuter");
	}
	
	/*
	 * 2.��������
	 */
	public Inter createInter() {
		return new Inter();
	}
	
	private  class Inter{//�ڲ���
		 //��Ա����
		int c=100;
		int d;
		//���췽��
		public Inter() {
			
		}
		//��Ա����
		public void methodInter() {
			System.out.println("methodInter");
			/*
			 * �ڵ����ⲿ���г�Ա�����ͷ���ʱ������ʽ��ָ��
			 * �ⲿ�������͵����ã��ⲿ���͵�����.this
			 * ---д���߲�д����
			 */
			System.out.println(a);
			System.out.println(b);
			methodOuter();
		}
		
	}

}
