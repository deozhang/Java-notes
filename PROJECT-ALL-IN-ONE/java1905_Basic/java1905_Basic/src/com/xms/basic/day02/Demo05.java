package com.xms.basic.day02;
/**
 * 自增和自减运算符：在原有的变量数据上增加1或者减少1，是
 * 								在变量名前后
 * 自增：++
 * 自减：--
 * 
 * 如果将自增/自减写在变量名前面，表示在使用这个变量前，变量自身加1/减1
 * 如果将自增/自减写在变量名后面，表示在使用这个变量后，变量自身加1/减1
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		int a=2;
//		int y=a++;
		int y=++a;
		System.out.println(y);//2//3
		System.out.println(a);//3//3
		
		double m=12.5;
		m--;
		System.out.println(m);
		
		char c='a';
		c++;
		System.out.println(c);
		
		
		
	}

}















































