package com.xms.se.day06;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/*
 * ʹ��RandomAccessFile�ļ��ĸ���
 * 1.һ���ֽ�һ���ֽڵĸ���
 * 2.ʹ�û����ֽ�����
 */
public class Demo03RandomAccessFile {
    public static void method1() throws Throwable {
    	/*
    	 * 1.һ���ֽ�һ���ֽڸ���
    	 */
    	//��ȡ
    	RandomAccessFile src=new RandomAccessFile("src.txt", "r");
    	//д��
    	RandomAccessFile dest=new RandomAccessFile("dest.txt", "rw");
    	/*
    	 * ѭ���Ķ�ȡ��д��
    	 */
    	long start=System.currentTimeMillis();
    	int index=-1;
    	while((index=src.read())!=-1) {
    		dest.write(index);
    	}
    	long end=System.currentTimeMillis();
    	System.out.println("�������ĵ�ʱ��Ϊ:"+(end-start));
    	src.close();
    	dest.close();
    	System.out.println("�������");
    }
    
    public static void method2() throws Throwable {
    	/*
    	 * 2.ʹ�û����ֽ�����
    	 * ���͵��źźʹ��źŽ�������,��߶�дЧ��
    	 * 
    	 * ��ʱ���������ֽ�����
    	 * byte[] buf=new byte[length]
    	 * 
    	 * �����ֽ������ʵ��:�����ݴ浽�ֽ�������,����CPU�Ը�������ж�ȡ��д�����
    	 */
    	//��ȡ
    	RandomAccessFile src=new RandomAccessFile("src.txt", "r");
    	//д��
    	RandomAccessFile destByte=new RandomAccessFile("destByte1.txt", "rw");
    	//�����ֽ�����
    	byte[] buf=new byte[1024*2];
    	//ѭ����ȡ��д��(�ֽ�����)
    	/*
    	 * read(byte[] byte)
    	 * һ�ζ�ȡһ��ָ�����ֽ�����
    	 * ����ֵΪ��ȡ����Ч���ֽڸ���
    	 * ���û�ж�ȡ�����ݷ���ֵ-1
    	 */
    	int index=-1;
    	long start=System.currentTimeMillis();
    	while((index=src.read(buf))!=-1) {
    		/*
    		 * write(byte[] buf):
    		 * һ��д��һ���ֽ�����,�ֽ�����೤
    		 * ��д��೤
    		 * ---void
    		 */
//    		destByte.write(buf);
    		/*
    		 * write(byte[] buf,int index,int length):
    		 * ��ָ�����ֽ�����,��ָ�����±�,д��ָ���ĳ���
    		 */
    		destByte.write(buf, 0, index);
    	}
    	//�ر����ͷſռ���Դ
    	long end=System.currentTimeMillis();
    	System.out.println("�������ĵ�ʱ��Ϊ:"+(end-start));
    	src.close();
    	destByte.close();
    	System.out.println("�������");
    }
    public static void main(String[] args) throws Throwable {
//		method1();
    	method2();
	}
}
