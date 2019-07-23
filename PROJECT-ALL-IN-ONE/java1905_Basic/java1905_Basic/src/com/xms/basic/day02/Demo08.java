package com.xms.basic.day02;
/***
 * 连接符："+"
 * 		可以实现字符串之间连接，也可以实现字符串与其他数据类型的连接
 * 注意：
 *	字符串使用连接符和任何数据类型进行连接，最终的数据的类型都为
 *	字符串类型
 * @author Administrator
 *
 */
public class Demo08 {
	public static void main(String[] args) {
		//字符串与字符串之间的连接
		String str1="北京";
		String str2="欢迎你";
		String str3=str1+str2;
		System.out.println(str3);
		//字符串与其他数据类型的连接
		int age=12;
		String str="年龄:"+age;
		System.out.println("年龄："+age);
		
		String s=""+100+200;//"100"+200//"100200"
		String s1=""+(100+200);//"100"+200//"100200"
		System.out.println(s);
		System.out.println(s1);
		
	}

}
