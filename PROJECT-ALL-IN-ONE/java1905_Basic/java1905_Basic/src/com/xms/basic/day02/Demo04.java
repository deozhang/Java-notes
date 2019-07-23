package com.xms.basic.day02;
/**
 * 算术运算符
 * 加：+，用法与数学中一致
 * 减：-，用法与数学中一致
 * 乘：*，用法与数学中一致
 * 除：/，用法与数学中一致
 * 取模（取余数）：%，用法与数学中一致
 * 
 * 
 * 自增和自减：++，--
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		/*
		 * 基本数据类型在进行算术运算（+，-，*，/）过程中
		 * 如果有大类型参与运算，结果会自动转成大类型
		 * 
		 * 整数，浮点数，字符类型都可以参与算术运算
		 */
		int a=1;
		int b=2;
		double c=3.5;
		char d='a';
		int r1=a+b;//结果是int类型
		double r2=a+c;//结果是double类型
		int r3=a+d;//结果是int类型
		double r4=c+d;//结果是double类型
		
		System.out.println(2-1);//1
		System.out.println(2.5-1);//1.5
		System.out.println(2.5*1);//2.5
		System.out.println(2.5*2);//5.0
		System.out.println('a'-2);//95
		
		System.out.println(5/2);//2--取整
		System.out.println(5.5/2);//2.75--除法
		System.out.println(1/2);//0
		
		
		System.out.println(5%2);//1
		System.out.println(5.5%2);//1.5
		System.out.println('a'%2);//1
		System.out.println(1%2);//1
		
		/*
		 * byte a1=1;
		 * byte a2=2;
		 * byte a3=a+b;//编译报错
		 * 
		 * 在算术运算中有byte,short，char字面量参与运算结果
		 * 会是int类型
		 */
		byte a1=1;
		byte a2=2;
		int a3=a+b;
		
		
		
		
		
		
		
	}

}





















































