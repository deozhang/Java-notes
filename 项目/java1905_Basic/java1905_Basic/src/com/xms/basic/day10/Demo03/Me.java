package com.xms.basic.day10.Demo03;
/**
 * ��--����
 * @author Administrator
 *
 */
public class Me implements Father,Teacher,Police {

	@Override
	public void protect() {
		// TODO Auto-generated method stub
		System.out.println("ά���ΰ�");
	}

	@Override
	public void teah() {
		// TODO Auto-generated method stub
		System.out.println("�ڿ�");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("��������");
	}

}
