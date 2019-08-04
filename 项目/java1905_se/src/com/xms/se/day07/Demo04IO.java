package com.xms.se.day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 第二组实现流:
 * 		缓冲字节输入输出流---高级流
 * 		BufferedInputStream:缓冲字节输入流
 * 			--read
 * 		BufferedOutputStream:缓冲字节输出流
 * 			--write
 * 
 * 这两个流内部各自维护着一个缓冲区(自带缓冲区)
 * 
 * 关闭流时:
 * 只需要将高级流关闭即可,低级流会随着高级流的关闭而关闭
 * 
 * 自带缓冲区和外加缓冲区的区别:
 * 	在读写相同的字节长度文件的情况下,外加缓冲字节数组要比自带缓冲字节数组
 * 的读写效率要高,原因是自带缓冲区在读写时多了一个换缓冲区的操作
 * --多一个"换车"环节
 * @author deo
 *
 */
public class Demo04IO {
	public static void method1() throws Throwable {
		//低级流
		OutputStream fos=new FileOutputStream("44.txt");
		//缓冲字节输出流--高级流
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//向目标文件中写出数据
//		fos.write(20);
		/*
		 * 自带缓冲区的输出流,只有将缓冲区存满,才会将缓冲区中数据
		 * 一次性写出,如果缓冲区没有存满,则会将写出的数据存入缓冲区中.
		 * 
		 * 如果想将未满的缓冲区数据写出:
		 * 1.flush()--强制将未满的缓冲区数据写出(降低读写效率)
		 * 2.关闭流
		 */
		bos.write(20);
//		bos.flush();
		bos.close();
		System.out.println("写出完毕");
	}
	public static void method2() throws Throwable{
		//输入
		FileInputStream fis=new FileInputStream("src.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		//输出
		//复制
		//关闭流
	}
	public static void main(String[] args) throws Throwable {
		method1();
	}
}



















