package com.xms.se.day06;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 复制文件
 * @author deo
 *
 */
public class Test01 {
	public static void main(String[] args) throws Throwable {
		//读取
		RandomAccessFile src=new RandomAccessFile("E:\\xms\\66\\第一阶段\\JavaBasic.pptx", "r");
		//写入
		RandomAccessFile dest=new RandomAccessFile("deo.pptx", "rw");
		//复制
		byte[] buf=new byte[1024*100];
		int index=-1;
		while((index=src.read(buf))!=-1) {
			dest.write(buf,0,index);
		}
		//关闭
		src.close();
		dest.close();
		System.out.println("复制完毕");
		
		
}
}
