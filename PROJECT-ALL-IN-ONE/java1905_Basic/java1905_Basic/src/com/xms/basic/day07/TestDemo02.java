package com.xms.basic.day07;
/**
 * 测试
 * @author Administrator
 *
 */
public class TestDemo02 {
	public static void main(String[] args) {
		Demo02 d=new Demo02();
		//现金
		d.payCash(20.5);
		//信用卡
		d.payCard("中国人民银行", "123456");
		System.out.println("-------------------------------------------------");
		//重载
		d.pay(20);
		d.pay("中国人民银行","123456");
		
				
		
	}

}














