package com.xms.se.day06;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * �����ļ�
 * @author deo
 *
 */
public class Test01 {
	public static void main(String[] args) throws Throwable {
		//��ȡ
		RandomAccessFile src=new RandomAccessFile("E:\\xms\\66\\��һ�׶�\\JavaBasic.pptx", "r");
		//д��
		RandomAccessFile dest=new RandomAccessFile("deo.pptx", "rw");
		//����
		byte[] buf=new byte[1024*100];
		int index=-1;
		while((index=src.read(buf))!=-1) {
			dest.write(buf,0,index);
		}
		//�ر�
		src.close();
		dest.close();
		System.out.println("�������");
		
		
}
}
