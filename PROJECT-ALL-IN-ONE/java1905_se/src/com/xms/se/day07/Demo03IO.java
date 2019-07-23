package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO流:输入输出流
 * 		输入和输出是相对于虚拟内存为主导
 * 		虚拟内存(程序)<--输入---物理内存(文件)
 * 		虚拟内存(程序)---输出-->物理内存(文件)
 * 
 * 	InputStream:抽象类,所有字节输入流的父类
 * 	OutputStream:抽象类,所有字节输出流的父类
 * 
 * 	节点流(低级流):可以从/向一个特定的位置读取/写出数据
  *     处理流(高级流):对一个已经存在的流进行封装,不会单独存在
 *  			是建立在低级流的基础之上;高级流可以嵌套使用
 * 
 * 	第一组实现类: 
 * 		文件字节输入输入流--低级流
 * 		FileInputStream:文件字节输入流
 * 			--read()...
 * 		FileOutputStream:文件字节输出流
 * 			--wirte(int n)...
 * @author deo
 *
 */
public class Demo03IO {
	public static void method1() throws Throwable {
		/*
		 * new FileOutputStream(String(File) name):
		 * new FileOutputStream(String(File) name,boolean append):
		 * name--文件路径(可以是字符串类型/File类型)
		 * append--true:可追加
		 * 		--false:不可追加
		 * 
		  * 和RandomAccessFile不同:
		 * RandomAccessFile写入字节时,将源文件中的字节进行等量覆盖
		 * FileOutputStream则是将源文件中所有数据清除后,然后再重新写入
		 * 
		 * 使用FileOutputStream想要在源文件中内容后面追加写入一些新的字节,则需要使用使用这个
		 * 构造方法,需要使用new FileOutputStream(String(File) name,boolean true):
		 */
		//文件字节输出流
		OutputStream fos=new FileOutputStream("33.txt",true);
		fos.write(20);//一次写出一个字节,低八位
		fos.write(30);//一次写出一个字节,低八位
		fos.write(40);//一次写出一个字节,低八位
		fos.write("中国".getBytes("gbk"));
		fos.close();//关闭流,释放空间资源
		System.out.println("输出成功");
	}
	public static void method2() throws Throwable {
		/*
		 * 文件复制
		 * 1.一个字节一个字节
		 * 2.缓冲字节数组
		 */
		//输入流
		InputStream fis=new FileInputStream("src.txt");
		//输出流
		OutputStream fos=new FileOutputStream("fos.txt");
		//创建字节数组
		byte[] buf=new byte[1024*100];
		//循环读取和写入
		int index=-1;
		while((index=fis.read())!=-1) {
			fos.write(buf,0,index);
		}
		//关闭流
		fis.close();
		fos.close();
		System.out.println("复制成功");
	}
	
	public static void main(String[] args) throws Throwable {
		//输出流
//		method1();
		method2();
	}
}















