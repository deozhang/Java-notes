package com.xms.basic.day02;
/**
 * 基本数据类型之间的转换
 * 从小到大之间的关系如下：
 * java中规定整数类型要小于浮点类型
 * byte-->short(char)-->int-->long-->float--->double
 * 1.自动类型转换
 * 2.强制类型转换
 * @author Administrator
 *
 */
public class Demo03 {
	//程序入口（main方法）
	public static void main(String[] args) {
		/*
		 * 自动类型转换：从小类型转向大类型的过程（小---->大）
		 */
		//整数与整数
		byte a=12;
		int a1=a;
		System.out.println("a1="+a1);
		//整数与浮点
		//整数转成浮点类型会加上精度
		int b=12;
		double b1=b;
		System.out.println("b1="+b1);
		double b2=12;
		//整数和字符
		char c='中';
		char c0='\u4e2d';
		int c1=c;
		int c2=c0;
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		/*
		 * 强制类型转换：从大类型转小类型的过程（大-->小）
		 * 							--溢出风险
		 * 语法：小类型 变量名=（小类型）大类型变量/字面量
		 */
		//整数与浮点
		double d=12.5;
		int d1=(int)d;
		System.out.println("d1="+d1);
		//整数与整数
		int e=129;
		byte e1=(byte)e;
		System.out.println("e1="+e1);
		//整数与字符
		char f='中';
		int f1=f;
		int f2='中';
		System.out.println("f1="+f1);
		System.out.println("f2="+f2);
		
		int g=20013;
		char g1=(char)g;
		System.out.println("g1="+g1);
		
		char g2=20013;
		System.out.println("g2="+g2);
		
		
		
		
		
	}
	

}






















































