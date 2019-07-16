package com.xms.se.day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 缓冲字符流--高级流
 * 	BufferedReader:缓冲字符输入流(<--->BufferedWriter:缓冲字符输出流)
 * 		new BufferedReader(InputStreamReader isr);
 * 		---readLine():
 * 			该方法一次读取一行数据,返回值为读取的String类型的数据,
 * 			如果没有数据可读,返回值为null
 * 	PrinterWriter:缓冲字符输出流
 * 		---new PrintWriter(File file):
 * 		---new PrintWriter(String path):
 * 		---new PrintWriter(OutStream os):
 * 		---new PrintWriter(OutStreamWriter ows):
 * 		---new PrintWriter(OutStreamWriter ows,boolean autoFlush):
 * 			--printf(Object obj):
 * 				可以写任何类型的数据,将数据存在未满的缓冲区中且不换行
 * 			--println(Object obj):
 * 				可以写任何类型的数据,将数据存在未满的缓冲区中,自动换行;
 * 				只有配合自动行刷新会将未满的缓冲区数据写出
 * @author deo
 *
 */
public class Demo01WR {
	public static void method1() throws Throwable {
		OutputStream os=new FileOutputStream("77.txt");
		OutputStreamWriter osw=new OutputStreamWriter(os,"gbk");
		PrintWriter pw=new PrintWriter(osw,true);//加true自动行刷新
		/**
		 * println():换行,换行符占两个字节,搭配自动行刷新的构造方法,
		 *  		才会将未满的缓冲区数据写出
		 * print():不会自动刷新,依然会将数据写在未满的缓冲区中,
		 * 			缓冲区满后,再一次性写出
		 * 
		  *  缓冲区大小:默认是8192
		 */
		pw.print("你们好");//在一行写入数据,存在未满的缓冲区中
		pw.println("你们好ln");//在一行写入数据,存在未满的缓冲区中,换行
		pw.print("你们好");//在一行写入数据,存在未满的缓冲区中
		pw.flush();
		System.out.println("缓冲字符输出流");
	}
	public static void method2() throws Throwable {
		/*
		  * 缓冲字符输入流
		 */
		InputStream fis=new FileInputStream("77.txt");//字节
		InputStreamReader isr=new InputStreamReader(fis);//字符
		BufferedReader br=new BufferedReader(isr);//缓冲字符 
		String str=null;
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
		br.close();
	}
	
	public static void main(String[] args) throws Throwable {
		method1();
		method2();
	}
}













