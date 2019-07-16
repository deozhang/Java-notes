package com.xms.se.day07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * �ַ���(ת����):���ֽ�--->�ַ�	�߼���     
 * 		����������
 * 			Reader:�ַ�����ĸ���
 * 			Writer:�ַ�����ĸ���
 * 		�ַ������ֽ���:Reader/Writerȫ�����ַ���
 * 		�ַ���:�����ַ�Ϊ������λ��д����
 * 		�ַ���ֻ�����ڶ�д�ı��ļ�(���ܶ�д��Ƶ,��Ƶ,ͼƬ)
 * 		�����Ҫ��д��������,��ʹ���ֽ���
 * 
 * 		ʵ����:
 * 			{@link InputStreamReader}�ַ�������
 * 				new InputStreamReader(InputStream is)
 * 				new InputStreamReader(InputStream is,String charSet)
 * 			{@link OutputStreamWriter}�ַ������
 * 				OutputStreamWriter(OutStream os)
 * 				OutputStreamWriter(OutStream os,String charSet)
 * 
 * 
 * @author deo
 *
 */
public class Demo06WR {
	public static void method1() throws Throwable {
		/*
		 * �ַ������
		 */
		//�ͼ���
		OutputStream os=new FileOutputStream("55.txt");
		//�ַ���--�߼���	��ϵͳĬ�ϵ��ַ�������
		OutputStreamWriter osw=new OutputStreamWriter(os);
		osw.write("�й���");
		osw.close();
		System.out.println("�ַ�������");
	}
	public static void method2() throws Throwable {
		/*
		 * ������
		 */
		//�ͼ���
		InputStream fis=new FileInputStream("55.txt");
		//�߼���--�ַ���
		InputStreamReader isr=new InputStreamReader(fis);
		/*
		 * read()
		 * һ�ζ�ȡһ���ַ�,�����ַ������벻ͬ
		 * ��Ӧ��ȡ���ֽ���
		 */
		
		int i=isr.read();
		System.out.println((char)i);
		isr.close();
		System.out.println("��ȡ���");
	}
	public static void method3() throws Throwable {
		/*
		 * �����ַ��������ı��ļ�
		 */
		//������
		InputStream fis=new FileInputStream("src.txt");//�ֽ���
		InputStreamReader isr=new InputStreamReader(fis,"utf-8");//�ַ���
		//�����
		OutputStream fos=new FileOutputStream("isr.txt");
		OutputStreamWriter osw=new OutputStreamWriter(fos,"utf-8");
		//ѭ����ȡ��д��
		int index=-1;
		while((isr.read())!=-1){
			osw.write(index);
		}
		//����
		isr.close();
		osw.close();
		System.out.println("�ַ����������");
	}
	
	public static void main(String[] args) throws Throwable {
//		method1();
//		method2();
		method3();
	}
}














