package com.xms.se.day07;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile����ָ��Ĳ�������
 * @author deo
 *
 */
public class Demo02RandomAccessFile {
	public static void method01() throws Throwable {
		RandomAccessFile raf=new RandomAccessFile("test.txt", "rw");
		/*
		 * getFilePointer()
		 * ��ȡ��ǰָ��ָ���λ��
		 * ����ֵΪLong���͵�����--ָ��ָ���λ��(��0��ʼ)
		 * �ڵ�ǰλ�÷�����һ�ζ�ȡ����д�����
		 */
		long lo1=raf.getFilePointer();
		System.out.println("lo1:"+lo1);
		raf.write(20);//һ��дһ���ֽ�,�Ͱ�λ
		raf.write(20);
		raf.write(40);
		raf.write(50);
		raf.writeInt(6);//һ��д�ĸ��ֽ�
		long lo2=raf.getFilePointer();
		System.out.println("lo2:"+lo2);
		System.out.println("�������");
		/*
		 * seek(long l):
		 * ����ָ��ĵ�ǰλ��
		 * ���õ����ļ���ͷ������λ�õ�ƫ����
		 * �ڸ�λ�÷�����ȡ����д�����
		 * --void
		 */
		int num1=raf.read();
		//д������,ָ���Զ����ƶ�,���-1
		System.out.println("num1:"+num1);
		raf.seek(2);
		int num2=raf.read();
		System.out.println("num2:"+num2);//���40
		/*
		 * skipBytes(int n):
		 * �������������n���ֽ�,�����������ֽ�,
		 * �ڸ�λ�÷�����һ�ζ�ȡ/д�����
		 * --ֻ�����λ����
		 * ����ֵΪ�������ֽ���
		 * ���븺ֵ�������κ��ֽ�(�൱������0)
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











