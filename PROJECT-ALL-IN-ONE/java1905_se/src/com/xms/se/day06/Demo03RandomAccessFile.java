package com.xms.se.day06;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/*
 * 使用RandomAccessFile文件的复制
 * 1.一个字节一个字节的复制
 * 2.使用缓冲字节数组
 */
public class Demo03RandomAccessFile {
    public static void method1() throws Throwable {
    	/*
    	 * 1.一个字节一个字节复制
    	 */
    	//读取
    	RandomAccessFile src=new RandomAccessFile("src.txt", "r");
    	//写入
    	RandomAccessFile dest=new RandomAccessFile("dest.txt", "rw");
    	/*
    	 * 循环的读取和写入
    	 */
    	long start=System.currentTimeMillis();
    	int index=-1;
    	while((index=src.read())!=-1) {
    		dest.write(index);
    	}
    	long end=System.currentTimeMillis();
    	System.out.println("复制消耗的时间为:"+(end-start));
    	src.close();
    	dest.close();
    	System.out.println("复制完毕");
    }
    
    public static void method2() throws Throwable {
    	/*
    	 * 2.使用缓冲字节数组
    	 * 降低电信号和磁信号交换次数,提高读写效率
    	 * 
    	 * 此时创建缓冲字节数组
    	 * byte[] buf=new byte[length]
    	 * 
    	 * 缓冲字节数组的实质:将数据存到字节数组中,再由CPU对该数组进行读取和写入操作
    	 */
    	//读取
    	RandomAccessFile src=new RandomAccessFile("src.txt", "r");
    	//写入
    	RandomAccessFile destByte=new RandomAccessFile("destByte1.txt", "rw");
    	//创建字节数组
    	byte[] buf=new byte[1024*2];
    	//循环读取和写入(字节数组)
    	/*
    	 * read(byte[] byte)
    	 * 一次读取一个指定的字节数组
    	 * 返回值为读取的有效的字节个数
    	 * 如果没有读取到数据返回值-1
    	 */
    	int index=-1;
    	long start=System.currentTimeMillis();
    	while((index=src.read(buf))!=-1) {
    		/*
    		 * write(byte[] buf):
    		 * 一次写入一个字节数组,字节数组多长
    		 * 就写入多长
    		 * ---void
    		 */
//    		destByte.write(buf);
    		/*
    		 * write(byte[] buf,int index,int length):
    		 * 将指定的字节数组,从指定的下标,写出指定的长度
    		 */
    		destByte.write(buf, 0, index);
    	}
    	//关闭流释放空间资源
    	long end=System.currentTimeMillis();
    	System.out.println("复制消耗的时间为:"+(end-start));
    	src.close();
    	destByte.close();
    	System.out.println("复制完毕");
    }
    public static void main(String[] args) throws Throwable {
//		method1();
    	method2();
	}
}
