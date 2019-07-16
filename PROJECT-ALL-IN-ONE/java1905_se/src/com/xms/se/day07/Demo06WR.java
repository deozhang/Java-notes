package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * 字符流(转换流):将字节--->字符	高级流     
 * 		两个抽象类
 * 			Reader:字符输入的父类
 * 			Writer:字符输出的父类
 * 		字符流和字节流:Reader/Writer全都是字符流
 * 		字符流:是以字符为操作单位读写数据
 * 		字符流只能用于读写文本文件(不能读写视频,音频,图片)
 * 		如果想要读写其他数据,则使用字节流
 * 
 * 		实现类:
 * 			{@link InputStreamReader}字符输入流
 * 				new InputStreamReader(InputStream is)
 * 				new InputStreamReader(InputStream is,String charSet)
 * 			{@link OutputStreamWriter}字符输出流
 * 				OutputStreamWriter(OutStream os)
 * 				OutputStreamWriter(OutStream os,String charSet)
 * 
 * 
 * @author deo
 *
 */
public class Demo06WR {
	public static void method1() throws Throwable {
		/*
		 * 字符输出流
		 */
		//低级流
		OutputStream os=new FileOutputStream("55.txt");
		//字符流--高级流	以系统默认的字符集编码
		OutputStreamWriter osw=new OutputStreamWriter(os);
		osw.write("中国人");
		osw.close();
		System.out.println("字符输出完毕");
	}
	public static void method2() throws Throwable {
		/*
		 * 输入流
		 */
		//低级流
		InputStream fis=new FileInputStream("55.txt");
		//高级流--字符流
		InputStreamReader isr=new InputStreamReader(fis);
		/*
		 * read()
		 * 一次读取一个字符,根据字符集编码不同
		 * 对应读取的字节数
		 */
		
		int i=isr.read();
		System.out.println((char)i);
		isr.close();
		System.out.println("读取完毕");
	}
	public static void method3() throws Throwable {
		/*
		 * 利用字符流复制文本文件
		 */
		//输入流
		InputStream fis=new FileInputStream("src.txt");//字节流
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");//字符流
		//输出流
		OutputStream fos=new FileOutputStream("isr.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		//循环读取和写出
		int index=-1;
		while((isr.read())!=-1){
			osw.write(index);
		}
		//关流
		isr.close();
		osw.close();
		System.out.println("字符流复制完毕");
	}
	
	public static void main(String[] args) throws Throwable {
//		method1();
//		method2();
		method3();
	}
}














