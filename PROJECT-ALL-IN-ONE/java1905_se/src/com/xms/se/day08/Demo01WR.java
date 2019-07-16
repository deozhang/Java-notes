package com.xms.se.day08;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * �����ַ���--�߼���
 * 	BufferedReader:�����ַ�������(<--->BufferedWriter:�����ַ������)
 * 		new BufferedReader(InputStreamReader isr);
 * 		---readLine():
 * 			�÷���һ�ζ�ȡһ������,����ֵΪ��ȡ��String���͵�����,
 * 			���û�����ݿɶ�,����ֵΪnull
 * 	PrinterWriter:�����ַ������
 * 		---new PrintWriter(File file):
 * 		---new PrintWriter(String path):
 * 		---new PrintWriter(OutStream os):
 * 		---new PrintWriter(OutStreamWriter ows):
 * 		---new PrintWriter(OutStreamWriter ows,boolean autoFlush):
 * 			--printf(Object obj):
 * 				����д�κ����͵�����,�����ݴ���δ���Ļ��������Ҳ�����
 * 			--println(Object obj):
 * 				����д�κ����͵�����,�����ݴ���δ���Ļ�������,�Զ�����;
 * 				ֻ������Զ���ˢ�»Ὣδ���Ļ���������д��
 * @author deo
 *
 */
public class Demo01WR {
	public static void method1() throws Throwable {
		OutputStream os=new FileOutputStream("77.txt");
		OutputStreamWriter osw=new OutputStreamWriter(os,"gbk");
		PrintWriter pw=new PrintWriter(osw,true);//��true�Զ���ˢ��
		/**
		 * println():����,���з�ռ�����ֽ�,�����Զ���ˢ�µĹ��췽��,
		 *  		�ŻὫδ���Ļ���������д��
		 * print():�����Զ�ˢ��,��Ȼ�Ὣ����д��δ���Ļ�������,
		 * 			����������,��һ����д��
		 * 
		  *  ��������С:Ĭ����8192
		 */
		pw.print("���Ǻ�");//��һ��д������,����δ���Ļ�������
		pw.println("���Ǻ�ln");//��һ��д������,����δ���Ļ�������,����
		pw.print("���Ǻ�");//��һ��д������,����δ���Ļ�������
		pw.flush();
		System.out.println("�����ַ������");
	}
	public static void method2() throws Throwable {
		/*
		  * �����ַ�������
		 */
		InputStream fis=new FileInputStream("77.txt");//�ֽ�
		InputStreamReader isr=new InputStreamReader(fis);//�ַ�
		BufferedReader br=new BufferedReader(isr);//�����ַ� 
		String str=null;
		while((str=br.readLine())!=null) {
			System.out.println(str);
		}
		br.close();
	}
	
	public static void main(String[] args) throws Throwable {
		method1();
		method2();
	}
}













