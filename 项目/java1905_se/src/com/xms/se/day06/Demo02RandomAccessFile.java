package com.xms.se.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile:随机访问文件的类
 * File类不能操作文件的内容,只能获取文件的周边信息
 * 如果想要操作文件内容,需要使用RandomAccessFile类
 * --该类的实力支持随机访问文件,对文件内容进行读取和写入操作
 * --此类是基于指针的操作,指针总是在当前位置读写数据
 * --两种模式
 * 	    "rw"可读可写
 *     "r"只读
 */
public class Demo02RandomAccessFile {
    public static void method1() throws Throwable {
    	/*
    	 * new RandomAccessFile(String path,String mode)
    	 * --自动创建该路径下的文件
    	 * new RandomAccessFile(File file,String mode)
    	 * --需要创建File对象,自动创建File路径下的文件
    	 * 
    	 * 该类的方法读取和写入都是参照虚拟内存
    	 * 虚拟内存(程序)<-----读取------物理内存(文件)
    	 * 虚拟内存(程序)-------写入---->物理内存(文件)
    	 * 
    	 * 如下两个方法都是在当前指针指向的位置发生读取和写入操作,操作完毕后,
    	 * 指针自动后移到下一个字节的位置.
    	 * 
    	 * write(int i):一次写入一个字节,写入的是int类型数据的低八位--void
    	 * read():读取一个字节,存入到int类型数据的低八位--int
    	 *     注意:数据读取完毕,返回值为-1(没有数据可读)
    	 * close():关闭流,释放空间资源
    	 */
    	//创建随机访问文件的实例
    	RandomAccessFile wt=new RandomAccessFile("11.txt", "rw");
//    	File file=new File("11.txt");
//    	RandomAccessFile wt1=new RandomAccessFile(file, "rw");
    	/*
    	 * RandomAccessFile类在写入时:
    	 * 1.如果写入的字节数小于等于原文件字节,则从原文件开头进行等量覆盖
    	 * 2.如果写入的字节数大于原文件的字节,则从原文件的开头进行等量覆盖后,
    	 * 则写入多余的字节
    	 */
    	wt.write(20);//写入一个字节,int类型的低八位
    	wt.write(255);//写入一个字节,int类型的低八位
    	wt.write(256);//写入一个字节,int类型的低八位
    	wt.close();//关闭通道,释放空间资源
    	System.out.println("写入完毕");
    }
    public static void method2() throws Throwable {
    	//创建随机访问文件的实例
    	RandomAccessFile rd=new RandomAccessFile("11.txt", "rw");
    	/*
    	 * 读取文件:注意,一定要在对应的路径中存在该文件,如果不存在,出现异常
    	 * java.io.FileNotFoundException
    	 */
    	int i1=rd.read();//一次读取一个字节,存到int类型的低八位.
    	int i2=rd.read();//一次读取一个字节,存到int类型的低八位.
    	int i3=rd.read();//一次读取一个字节,存到int类型的低八位.
    	int i4=rd.read();//一次读取一个字节,存到int类型的低八位.
    	System.out.println(i1);
    	System.out.println(i2);
    	System.out.println(i3);
    	System.out.println(i4);
    	rd.close();
    	System.out.println("读取完毕");
    }
    public static void main(String[] args) throws Throwable {
		method1();
		method2();
	}
}








