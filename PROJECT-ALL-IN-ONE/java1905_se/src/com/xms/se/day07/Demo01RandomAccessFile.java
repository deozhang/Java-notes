package com.xms.se.day07;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * д���ַ���
 * @author deo
 *
 */
public class Demo01RandomAccessFile {
	public static void method01() throws Throwable {
		/**
		 * �ַ�������:
		 * ����ԭ��:�����ʽ�ͽ����ʽ��ͳһ
		 * 
		 * GBK:һ��Ӣ����һ���ֽڱ�ʾ
		 * 		һ�����ĺ����ַ��������ֽڱ�ʾ
		 * 
		 * UTF-8:�����
		 * 		һ��Ӣ����һ���ֽڱ�ʾ
		 * 		һ�����ĺ����ַ��������ֽڱ�ʾ
		 * 		(�������������ֽ�/�ĸ��ֽڱ�ʾ)
		 * gb2312:���ķ���
		 * UniCode:ֻ������Ӣ��,һ���ֽڱ�ʾһ���ַ�
		 */
		/*
		 * д���ַ���--ת���ֽ�--д���ӦĿ���ļ���
		 * 
		 * 1.String���͵�getBytes():
		 * --����ǰ�ַ���������ϵͳĬ�ϵ��ַ�������ת�ɶ�Ӧ���ֽ�
		 * --����ֵΪ��Ӧ���ֽ�����
		 * 2.String���͵�getByte(String charSet):
		 * --����ǰ�ַ���������ָ�����ַ�������ת�ɶ�Ӧ���ֽ�
		 * --����ֵΪ��Ӧ���ֽ�����
		 */
		RandomAccessFile raf=new RandomAccessFile("11.txt", "rw");
		String str="�й�����";
		//����ϵͳĬ�ϵ��ַ�������ת��Ϊ�ֽ�����
		byte[] buf=str.getBytes();
		System.out.println(buf.length);
		raf.write(buf);
		raf.close();
		System.out.println("д�����");
		String s1=new String(buf,"utf-8");//��utf-8���ʱ��ʾ����
		System.out.println(s1);		
	}
	public static void main(String[] args) throws Throwable {
		method01();
	}
}













