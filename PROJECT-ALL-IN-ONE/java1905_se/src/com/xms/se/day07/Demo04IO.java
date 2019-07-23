package com.xms.se.day07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * �ڶ���ʵ����:
 * 		�����ֽ����������---�߼���
 * 		BufferedInputStream:�����ֽ�������
 * 			--read
 * 		BufferedOutputStream:�����ֽ������
 * 			--write
 * 
 * ���������ڲ�����ά����һ��������(�Դ�������)
 * 
 * �ر���ʱ:
 * ֻ��Ҫ���߼����رռ���,�ͼ��������Ÿ߼����Ĺرն��ر�
 * 
 * �Դ�����������ӻ�����������:
 * 	�ڶ�д��ͬ���ֽڳ����ļ��������,��ӻ����ֽ�����Ҫ���Դ������ֽ�����
 * �Ķ�дЧ��Ҫ��,ԭ�����Դ��������ڶ�дʱ����һ�����������Ĳ���
 * --��һ��"����"����
 * @author deo
 *
 */
public class Demo04IO {
	public static void method1() throws Throwable {
		//�ͼ���
		OutputStream fos=new FileOutputStream("44.txt");
		//�����ֽ������--�߼���
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		//��Ŀ���ļ���д������
//		fos.write(20);
		/*
		 * �Դ��������������,ֻ�н�����������,�ŻὫ������������
		 * һ����д��,���������û�д���,��Ὣд�������ݴ��뻺������.
		 * 
		 * ����뽫δ���Ļ���������д��:
		 * 1.flush()--ǿ�ƽ�δ���Ļ���������д��(���Ͷ�дЧ��)
		 * 2.�ر���
		 */
		bos.write(20);
//		bos.flush();
		bos.close();
		System.out.println("д�����");
	}
	public static void method2() throws Throwable{
		//����
		FileInputStream fis=new FileInputStream("src.txt");
		BufferedInputStream bis=new BufferedInputStream(fis);
		//���
		//����
		//�ر���
	}
	public static void main(String[] args) throws Throwable {
		method1();
	}
}



















