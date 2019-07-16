package com.xms.basic.day07;
/**
 * 类的命名和变量的名组成字符一致
 * 类命名时要求首字符大写，建议不使用中文
 * --关键字class表示为类
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo01 {//类名
	/*
	 * 封装一个人，书写个人信息的方法
	 *---- 姓名，性别，年龄，身份证号
	 * 
	 */														
	public static void printInformation(Human h) {
		System.out.println("姓名："+h.name);
		System.out.println("姓别："+h.sex);
		System.out.println("年龄："+h.age);
		System.out.println("身份号："+h.id);
	}

}



































