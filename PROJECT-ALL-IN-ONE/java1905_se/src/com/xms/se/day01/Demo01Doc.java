package com.xms.se.day01;
/**
 * javaMe：微型java，实在javaSe的基础上，删除掉部分接口，方法，增添一份关于移植手机上制作手机游戏的接口，类等
 * javaSe：基础java，主要介绍jdk封装一些类，接口，方法等用法
 * javaEE：企业级的开发，在javaSe的基础上增加关于网络编程的接口和类，及方法等--第三阶段
 * 
 * 文档注释：在类的开头，或者方法的开头，做介绍类或方法
 * 只有文档在生成doc文档时才会显示
 * 
 * Export-java-javaDoc  生成doc文档
 * Export-java-JarFile     生成架包(封装好的类)
 * 
 * 导入架包--在项目下创建一个lib文件夹，将架包复制到该文件夹中，右键-添加资源路径 add toBuild path
 * 
 * @author Administrator
 * @see 参考文献
 * @version 封装该类时所处的jdk版本
 * @since 从哪个版本开始支持，这种用法或者写法
 *
 */
public class Demo01Doc {
	//单行注释--解释某一句代码的意思，一般放在代码上方或者后方
	public static void main(String args[]) {
		/*
		 * 多行注释--在一部分逻辑代码的上方，解释这段代码的用法和意义
		 * 
		 * 
		 * 这是一个输出语句，将程序中数据输出在控制上，做展示数据功能使用，后期作为调试工具，
		 *不参与任何的逻辑运算--仅仅作为展示数据使用
		 */
		System.out.println();
	}
	
	/**
	 * 这是一个add1（）方法
	 * 功能是输出一句话
	 */
	public void add1() {
		System.out.println("add1");
	}
	/**
	 * 方法介绍：add1(int a, int b),表示为两个int类型得数据相加的功能
	 * @param 表示整数类型a 
	 * @param 表示整数类型b
	 * @return 两个数相加的结果
	 */
	public int add1(int a,int b) {
		System.out.println("add1");
		return 100;
	}
}
