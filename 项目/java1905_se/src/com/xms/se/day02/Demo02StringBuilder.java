package com.xms.se.day02;
/**
 * 可变字符序列的类
 * StringBuilder:线程不安全，并发处理，效率较高
 * StringBuffer:线程安全，同步处理，效率较低
 * 
 * 这两类中的方法一致，用法一致
 * 通过这两个类可以对字符串进行修改
 * 		--追加，删除，替换，插入，翻转
 * 		--返回值为当前类型的当前对象
 * 			可以在一个对象上进行连续的修改，方便对字符串数据的操作
 * @author Administrator
 *
 */
public class Demo02StringBuilder {
	public static void  method1() {
		//创建一个可变字符序列对象
		StringBuffer sb=new StringBuffer();//无参
		StringBuffer sb1=new StringBuffer("abc");//有参
		
		/*
		 * append(String str):
		 * 追加指定的字符串
		 * 返回值为当前类型的当前对象
		 */
		sb.append("hello");
		System.out.println(sb);
		sb.append("world");
		System.out.println(sb);
		
		/*
		 * delete(int start,int end):
		 * 删除指定范围内的字符串--前包括后不包括
		 * 返回值为当前类型得当前对象
		 */
		sb.delete(8, 10);//删除ld
		//sb.delete(8, 11);   效果一样， 都是截取到最后一位     
		System.out.println(sb);
		
		/*
		 * replace(int start,int end,String str):
		 *	将指定区域内的字符串替换成指定字符串（str）
		 *	返回值为当前类型的当前对象
		 */
		//hellowor --->javawor
		sb.replace(0,5,"java");
		System.out.println(sb);
		
		/*
		 * insert(int index,String str):
		 * 在指定的位置插入指定的字符串，该位置及往后的字符一次向后移动
		 * 返回值为当前类型的当前对象
		 */
		//javawor --->java!wor
		sb.insert(4, "!");
		System.out.println(sb);
		
		/*
		 * reverse():
		 * 将当前可变字符序列中的字符串翻转
		 * 返回值为当前类型的当前对象
		 */
		//java!wor --->row!avaj
		sb.reverse();
		System.out.println(sb);
		
		
	}
	
	//对一个对象进行连续的修改
	public static void method2() {
		StringBuilder sb=new StringBuilder();
		sb.append("hello").append("world").delete(8, 10).replace(0,5,"java").insert(4,"!").reverse();
		System.out.println(sb);
	}
	public static void main(String args[]) {
		method1();
		method2();
	}
}
