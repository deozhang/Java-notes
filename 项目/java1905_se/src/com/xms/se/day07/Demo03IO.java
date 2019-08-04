package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO��:���������
 * 		��������������������ڴ�Ϊ����
 * 		�����ڴ�(����)<--����---�����ڴ�(�ļ�)
 * 		�����ڴ�(����)---���-->�����ڴ�(�ļ�)
 * 
 * 	InputStream:������,�����ֽ��������ĸ���
 * 	OutputStream:������,�����ֽ�������ĸ���
 * 
 * 	�ڵ���(�ͼ���):���Դ�/��һ���ض���λ�ö�ȡ/д������
  *     ������(�߼���):��һ���Ѿ����ڵ������з�װ,���ᵥ������
 *  			�ǽ����ڵͼ����Ļ���֮��;�߼�������Ƕ��ʹ��
 * 
 * 	��һ��ʵ����: 
 * 		�ļ��ֽ�����������--�ͼ���
 * 		FileInputStream:�ļ��ֽ�������
 * 			--read()...
 * 		FileOutputStream:�ļ��ֽ������
 * 			--wirte(int n)...
 * @author deo
 *
 */
public class Demo03IO {
	public static void method1() throws Throwable {
		/*
		 * new FileOutputStream(String(File) name):
		 * new FileOutputStream(String(File) name,boolean append):
		 * name--�ļ�·��(�������ַ�������/File����)
		 * append--true:��׷��
		 * 		--false:����׷��
		 * 
		  * ��RandomAccessFile��ͬ:
		 * RandomAccessFileд���ֽ�ʱ,��Դ�ļ��е��ֽڽ��е�������
		 * FileOutputStream���ǽ�Դ�ļ����������������,Ȼ��������д��
		 * 
		 * ʹ��FileOutputStream��Ҫ��Դ�ļ������ݺ���׷��д��һЩ�µ��ֽ�,����Ҫʹ��ʹ�����
		 * ���췽��,��Ҫʹ��new FileOutputStream(String(File) name,boolean true):
		 */
		//�ļ��ֽ������
		OutputStream fos=new FileOutputStream("33.txt",true);
		fos.write(20);//һ��д��һ���ֽ�,�Ͱ�λ
		fos.write(30);//һ��д��һ���ֽ�,�Ͱ�λ
		fos.write(40);//һ��д��һ���ֽ�,�Ͱ�λ
		fos.write("�й�".getBytes("gbk"));
		fos.close();//�ر���,�ͷſռ���Դ
		System.out.println("����ɹ�");
	}
	public static void method2() throws Throwable {
		/*
		 * �ļ�����
		 * 1.һ���ֽ�һ���ֽ�
		 * 2.�����ֽ�����
		 */
		//������
		InputStream fis=new FileInputStream("src.txt");
		//�����
		OutputStream fos=new FileOutputStream("fos.txt");
		//�����ֽ�����
		byte[] buf=new byte[1024*100];
		//ѭ����ȡ��д��
		int index=-1;
		while((index=fis.read())!=-1) {
			fos.write(buf,0,index);
		}
		//�ر���
		fis.close();
		fos.close();
		System.out.println("���Ƴɹ�");
	}
	
	public static void main(String[] args) throws Throwable {
		//�����
//		method1();
		method2();
	}
}















