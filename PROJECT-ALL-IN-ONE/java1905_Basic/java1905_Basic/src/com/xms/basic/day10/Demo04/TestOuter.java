package com.xms.basic.day10.Demo04;

import java.net.NetworkInterface;
/**
 * ����
 * @author Administrator
 *
 */
public class TestOuter {
	public static void main(String[] args) {
		Outer o=new Outer();
		//��ȡ�ڲ������͵Ķ���
		//1.ͨ�����ⲿ���������ڲ���ĳ�Ա����
		System.out.println(o.i);
		//2.ͨ����������
		System.out.println(o.createInter());
		
	}

}
