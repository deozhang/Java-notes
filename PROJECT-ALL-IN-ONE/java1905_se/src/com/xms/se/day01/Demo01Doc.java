package com.xms.se.day01;
/**
 * javaMe��΢��java��ʵ��javaSe�Ļ����ϣ�ɾ�������ֽӿڣ�����������һ�ݹ�����ֲ�ֻ��������ֻ���Ϸ�Ľӿڣ����
 * javaSe������java����Ҫ����jdk��װһЩ�࣬�ӿڣ��������÷�
 * javaEE����ҵ���Ŀ�������javaSe�Ļ��������ӹ��������̵Ľӿں��࣬��������--�����׶�
 * 
 * �ĵ�ע�ͣ�����Ŀ�ͷ�����߷����Ŀ�ͷ����������򷽷�
 * ֻ���ĵ�������doc�ĵ�ʱ�Ż���ʾ
 * 
 * Export-java-javaDoc  ����doc�ĵ�
 * Export-java-JarFile     ���ɼܰ�(��װ�õ���)
 * 
 * ����ܰ�--����Ŀ�´���һ��lib�ļ��У����ܰ����Ƶ����ļ����У��Ҽ�-�����Դ·�� add toBuild path
 * 
 * @author Administrator
 * @see �ο�����
 * @version ��װ����ʱ������jdk�汾
 * @since ���ĸ��汾��ʼ֧�֣������÷�����д��
 *
 */
public class Demo01Doc {
	//����ע��--����ĳһ��������˼��һ����ڴ����Ϸ����ߺ�
	public static void main(String args[]) {
		/*
		 * ����ע��--��һ�����߼�������Ϸ���������δ�����÷�������
		 * 
		 * 
		 * ����һ�������䣬����������������ڿ����ϣ���չʾ���ݹ���ʹ�ã�������Ϊ���Թ��ߣ�
		 *�������κε��߼�����--������Ϊչʾ����ʹ��
		 */
		System.out.println();
	}
	
	/**
	 * ����һ��add1��������
	 * ���������һ�仰
	 */
	public void add1() {
		System.out.println("add1");
	}
	/**
	 * �������ܣ�add1(int a, int b),��ʾΪ����int���͵�������ӵĹ���
	 * @param ��ʾ��������a 
	 * @param ��ʾ��������b
	 * @return ��������ӵĽ��
	 */
	public int add1(int a,int b) {
		System.out.println("add1");
		return 100;
	}
}
