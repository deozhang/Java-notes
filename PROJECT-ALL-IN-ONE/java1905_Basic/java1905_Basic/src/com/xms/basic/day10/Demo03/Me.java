package com.xms.basic.day10.Demo03;
/**
 * 我--类型
 * @author Administrator
 *
 */
public class Me implements Father,Teacher,Police {

	@Override
	public void protect() {
		// TODO Auto-generated method stub
		System.out.println("维护治安");
	}

	@Override
	public void teah() {
		// TODO Auto-generated method stub
		System.out.println("授课");
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("教育孩子");
	}

}
