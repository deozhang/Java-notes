package com.xms.se.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/*
 * RandomAccessFile:��������ļ�����
 * File�಻�ܲ����ļ�������,ֻ�ܻ�ȡ�ļ����ܱ���Ϣ
 * �����Ҫ�����ļ�����,��Ҫʹ��RandomAccessFile��
 * --�����ʵ��֧����������ļ�,���ļ����ݽ��ж�ȡ��д�����
 * --�����ǻ���ָ��Ĳ���,ָ�������ڵ�ǰλ�ö�д����
 * --����ģʽ
 * 	    "rw"�ɶ���д
 *     "r"ֻ��
 */
public class Demo02RandomAccessFile {
    public static void method1() throws Throwable {
    	/*
    	 * new RandomAccessFile(String path,String mode)
    	 * --�Զ�������·���µ��ļ�
    	 * new RandomAccessFile(File file,String mode)
    	 * --��Ҫ����File����,�Զ�����File·���µ��ļ�
    	 * 
    	 * ����ķ�����ȡ��д�붼�ǲ��������ڴ�
    	 * �����ڴ�(����)<-----��ȡ------�����ڴ�(�ļ�)
    	 * �����ڴ�(����)-------д��---->�����ڴ�(�ļ�)
    	 * 
    	 * �����������������ڵ�ǰָ��ָ���λ�÷�����ȡ��д�����,������Ϻ�,
    	 * ָ���Զ����Ƶ���һ���ֽڵ�λ��.
    	 * 
    	 * write(int i):һ��д��һ���ֽ�,д�����int�������ݵĵͰ�λ--void
    	 * read():��ȡһ���ֽ�,���뵽int�������ݵĵͰ�λ--int
    	 *     ע��:���ݶ�ȡ���,����ֵΪ-1(û�����ݿɶ�)
    	 * close():�ر���,�ͷſռ���Դ
    	 */
    	//������������ļ���ʵ��
    	RandomAccessFile wt=new RandomAccessFile("11.txt", "rw");
//    	File file=new File("11.txt");
//    	RandomAccessFile wt1=new RandomAccessFile(file, "rw");
    	/*
    	 * RandomAccessFile����д��ʱ:
    	 * 1.���д����ֽ���С�ڵ���ԭ�ļ��ֽ�,���ԭ�ļ���ͷ���е�������
    	 * 2.���д����ֽ�������ԭ�ļ����ֽ�,���ԭ�ļ��Ŀ�ͷ���е������Ǻ�,
    	 * ��д�������ֽ�
    	 */
    	wt.write(20);//д��һ���ֽ�,int���͵ĵͰ�λ
    	wt.write(255);//д��һ���ֽ�,int���͵ĵͰ�λ
    	wt.write(256);//д��һ���ֽ�,int���͵ĵͰ�λ
    	wt.close();//�ر�ͨ��,�ͷſռ���Դ
    	System.out.println("д�����");
    }
    public static void method2() throws Throwable {
    	//������������ļ���ʵ��
    	RandomAccessFile rd=new RandomAccessFile("11.txt", "rw");
    	/*
    	 * ��ȡ�ļ�:ע��,һ��Ҫ�ڶ�Ӧ��·���д��ڸ��ļ�,���������,�����쳣
    	 * java.io.FileNotFoundException
    	 */
    	int i1=rd.read();//һ�ζ�ȡһ���ֽ�,�浽int���͵ĵͰ�λ.
    	int i2=rd.read();//һ�ζ�ȡһ���ֽ�,�浽int���͵ĵͰ�λ.
    	int i3=rd.read();//һ�ζ�ȡһ���ֽ�,�浽int���͵ĵͰ�λ.
    	int i4=rd.read();//һ�ζ�ȡһ���ֽ�,�浽int���͵ĵͰ�λ.
    	System.out.println(i1);
    	System.out.println(i2);
    	System.out.println(i3);
    	System.out.println(i4);
    	rd.close();
    	System.out.println("��ȡ���");
    }
    public static void main(String[] args) throws Throwable {
		method1();
		method2();
	}
}








