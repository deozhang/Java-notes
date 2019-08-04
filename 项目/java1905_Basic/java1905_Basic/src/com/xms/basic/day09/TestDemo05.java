package com.xms.basic.day09;
/**
 * 测试类
 * @author Administrator
 *
 */
public class TestDemo05 {
	public static void main(String[] args) {
		Demo05 d=new Demo05();
		d.show();
		System.out.println("-------------------------------");
		Demo05 d1=new Demo05();
		d1.show();
//		d1.time();//不建议使用
		Demo05.time();//建议
	}

}
