package com.xms.basic.day10.Demo04;

import java.net.NetworkInterface;
/**
 * 测试
 * @author Administrator
 *
 */
public class TestOuter {
	public static void main(String[] args) {
		Outer o=new Outer();
		//获取内部类类型的对象
		//1.通过在外部类中声明内部类的成员变量
		System.out.println(o.i);
		//2.通过工厂方法
		System.out.println(o.createInter());
		
	}

}
