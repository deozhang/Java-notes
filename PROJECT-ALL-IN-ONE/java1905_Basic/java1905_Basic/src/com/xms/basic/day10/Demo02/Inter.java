package com.xms.basic.day10.Demo02;
/**
 * �ӿڣ�
 * 	java���������Ϊ���ĵļ�����������
 * ---����������Ϊ���ĵ�����ӿڱ��
 * 
 * �ࣺ��װ����---����
 * �ӿڣ���װ�����ݲ����ķ���---��Ϊ
 * 
 * 1.�ӿڣ�����һ�ֱ�׼��һ�ֹ淶---�ƶ���׼
 * 		---�ؼ��֣�interface��ʾ�ӿ�
 * 2.�ӿ��а������������󷽷�����̬������default����---jdk1.8
 * 	   �ӿ��а������������󷽷�---jdk1.6
 * 3.�ӿڲ���ʵ����,��Ҫ��ͨ��ʵ�֣�ʵ�ֽӿ����Ϊʵ����
 * 		��implements��ʾʵ�ֹ�ϵ(����imple:��ʾʵ����),
 * 		���ʵ�������Ҫ�̳У�����Ҫʵ�֣�ԭ���ȼ̳���ʵ��
 * 		1.�ӿڵ�ʵ��--֧�ֶ�ʵ�֣������ӿ�֮���ö��Ÿ���
 * 		2.�ӿ���ӿ�֮��֧�ֶ�̳�
 * 4.ʵ������Ҫʵ�ֽӿ������еĳ��󷽷�
 * 5.�ӿ�ʵ�ַ�����Ȩ�����η�Ҫ���ڽӿ��з�����Ȩ�����η�
 * 
 * �ӿںͳ����������:
 * 		1.������ɣ�
 * 				�����ࣺ
 * 						1.��Ա����
 * 						2.���췽��
 * 						3.��������ͨ��static�������ͳ��󷽷�
 * 				�ӿڣ�
 * 						1.�г���
 * 						2.û�й��췽��
 * 						3.�г��󷽷�����̬������default����
 * 	
 * 		2.���͹�ϵ��
 * 				�����࣬����ӿڣ��ӿ���ӿ�
 * 		3.��ͬ�㣺
 * 				�����ܱ�ʵ��������Ҫ��̬����ʵ��ʵ����
 * 
 * 
 * �༭����
 * 			�������ʹ�����������---extends
 * 			�ӿڴ���ʵ����---implements
 * 
 * 
 * @author Administrator
 *
 */


public interface Inter {
	//����
	public static final int NUM=10;
	int NUM1=10;//public static final
	final int NUM2=10; //public static 
	
	//���󷽷�
	public abstract void add1();
	void add2();//public abstract 
	
	//��̬����
	public static void add3() {
		System.out.println("��̬����");
	}
	
	//default����---defaultֻ���ڽӿ������η���
	default void add4() {
		System.out.println("defualt-add4()");
	}
	
//	public void show() {
//		System.out.println("show");
//	}
	
}



































