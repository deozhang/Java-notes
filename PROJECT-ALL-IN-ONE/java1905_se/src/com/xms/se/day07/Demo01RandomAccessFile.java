package com.xms.se.day07;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 写入字符串
 * @author deo
 *
 */
public class Demo01RandomAccessFile {
	public static void method01() throws Throwable {
		/**
		 * 字符集编码:
		 * 乱码原因:编码格式和解码格式不统一
		 * 
		 * GBK:一个英文用一个字节表示
		 * 		一个中文汉字字符用两个字节表示
		 * 
		 * UTF-8:万国码
		 * 		一个英文用一个字节表示
		 * 		一个中文汉字字符用三个字节表示
		 * 		(极少数用两个字节/四个字节表示)
		 * gb2312:中文繁体
		 * UniCode:只服务于英文,一个字节表示一个字符
		 */
		/*
		 * 写入字符串--转成字节--写入对应目标文件中
		 * 
		 * 1.String类型的getBytes():
		 * --将当前字符串对象按照系统默认的字符集编码转成对应的字节
		 * --返回值为对应的字节数组
		 * 2.String类型的getByte(String charSet):
		 * --将当前字符串对象按照指定的字符集编码转成对应的字节
		 * --返回值为对应的字节数组
		 */
		RandomAccessFile raf=new RandomAccessFile("11.txt", "rw");
		String str="中国人民";
		//按照系统默认的字符集编码转换为字节数组
		byte[] buf=str.getBytes();
		System.out.println(buf.length);
		raf.write(buf);
		raf.close();
		System.out.println("写入完毕");
		String s1=new String(buf,"utf-8");//以utf-8输出时显示乱码
		System.out.println(s1);		
	}
	public static void main(String[] args) throws Throwable {
		method01();
	}
}













