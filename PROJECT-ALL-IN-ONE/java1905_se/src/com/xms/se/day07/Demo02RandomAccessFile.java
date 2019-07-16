package com.xms.se.day07;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile基于指针的操作的类
 * @author deo
 *
 */
public class Demo02RandomAccessFile {
	public static void method01() throws Throwable {
		RandomAccessFile raf=new RandomAccessFile("test.txt", "rw");
		/*
		 * getFilePointer()
		 * 获取当前指针指向的位置
		 * 返回值为Long类型的数据--指针指向的位置(从0开始)
		 * 在当前位置发生下一次读取或者写入操作
		 */
		long lo1=raf.getFilePointer();
		System.out.println("lo1:"+lo1);
		raf.write(20);//一次写一个字节,低八位
		raf.write(20);
		raf.write(40);
		raf.write(50);
		raf.writeInt(6);//一次写四个字节
		long lo2=raf.getFilePointer();
		System.out.println("lo2:"+lo2);
		System.out.println("操作完毕");
		/*
		 * seek(long l):
		 * 调整指针的当前位置
		 * 设置到此文件开头到测量位置的偏移量
		 * 在该位置发生读取或者写入操作
		 * --void
		 */
		int num1=raf.read();
		//写操作后,指针自动后移动,输出-1
		System.out.println("num1:"+num1);
		raf.seek(2);
		int num2=raf.read();
		System.out.println("num2:"+num2);//输出40
		/*
		 * skipBytes(int n):
		 * 尝试跳过输入的n个字节,丢弃跳过的字节,
		 * 在该位置发生下一次读取/写入操作
		 * --只能象后位置跳
		 * 返回值为跳过的字节数
		 * 输入负值则不跳过任何字节(相当于输入0)
		 */
		raf.seek(2);
		int t=raf.skipBytes(5);
		System.out.println("t:"+t);
		int num3=raf.read();
		System.out.println("num3:"+num3);
	}

	public static void main(String[] args) throws Throwable {
		method01();
	}
}











