package com.xms.se.day06;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Demo01File {
    public static void method1() {
    	//����file����
    	File file1=new File("D:\\1");
    	File file2=new File("D:\\1.txt");
       /*
        * File.separator(����)
        * ���ã����Կ�ƽ̨�ļ��ָ����Ĳ�����
        */
    	File file3=new File("D:"+File.separator+"1");
    }
    
    public static void method2() {
    	/*
    	 * ��ȡ�ļ��ܱ���Ϣ
    	 */
    	File file = new File("1.txt");
    	/*
    	 * getName():
    	 * 1.��ȡ��ǰ�ļ����ļ���
    	 * 2.����ֵΪString����
    	 */
    	String name=file.getName();
    	System.out.println("�ļ�/�ļ��У�"+name);
    	/*
    	 * exists()
    	 * 1.�ж��ļ�/�ļ����Ƿ����
    	 * 2.����ֵ�ǲ�������
    	 */
    	
    	/*
    	 * length()
    	 * 1.��ʾ�ļ���ռ���ֽ���
    	 * 2.����ֵΪ�ֽڸ���(long����)
    	 * 3.�ļ����ǲ�ռ�ֽڵ�
    	 */
    	
    	/*
    	 * canRead()
    	 * canWrite()
    	 * canExecute()
    	 * 
    	 */
    	
    	/*
    	 * lastModifiled()
    	 * 1.�ļ�����޸ĵ�ʱ��
    	 * 2.����ֵ���޸�ʱ�����1970/01/01�ĺ�����
    	 */
    	long lon=file.lastModified();
    	System.out.println("lon:"+lon);
    }
    
    public static void method3() throws Throwable {
    	/*
    	 * isFile()/isDirectory
    	 * 1.�жϵ�ǰfile�����Ƿ����ļ�/�ļ���
    	 */
    	
    	/*
    	 * createNewFile()
    	 * 1.������ǰFile·���µ��ļ�
    	 * 2.����ֵΪ��������
    	 * 
    	 * delete()
    	 * 1.ɾ����ǰFile·���µ��ļ�/�ļ���(�ļ���Ϊ��ʱ������ɾ��)
    	 * 2.����ֵΪ��������
    	 * 
    	 * ����/ɾ���ļ�/�ļ��в���,
    	 * 1.���ж��Ƿ����
    	 * 2.�ٽ��д���/ɾ��
    	 */
    	File file=new File("test.txt");
    	if(!file.exists()) {
    		//�����ļ�
    		boolean bo=file.createNewFile();
    		System.out.println("bo:"+bo);
    	}
    	if(file.exists()) {
    		//ɾ���ļ�
    		boolean bo1=file.delete();
    		System.out.println("bo1:"+bo1);
    	}
    	
    	/*
    	 * mkdir()���������ļ���
    	 * mkdirs()�����༶�ļ���
    	 * ����ֵΪ��������
    	 */
    	File file2=new File("test01");
    	File file3=new File("test02\\a\\b\\c");
    	if(!file2.exists()) {
    		boolean bo2=file2.mkdir();
    		System.out.println("bo2:"+bo2);
    	}
    	if(!file3.exists()) {
    		boolean bo3=file3.mkdirs();
    		System.out.println("bo3:"+bo3);
    	}
    	/*
    	 * ɾ�������ļ���
    	 */
    	if(file2.isDirectory()) {
    		boolean bo4=file2.delete();
    		System.out.println("bo4"+bo4);
    	}


    	/*
    	 * getParentFile()
    	 * ��ȡ��ǰfile�����ļ�/�ļ����������е��ϼ�·��
    	 * ����ֵΪfile����
    	 * getParent()
    	 * ��ȡ��ǰfile�����ļ�/�ļ����������е��ϼ�·��
    	 * ����ֵΪstring����
    	 * 
    	 * д���files·����ʲô,�ͷ��ض�Ӧ·��
    	 */
    	
    	/*
    	 * listFile()
    	 * �鿴��ǰfile����·�������е��ļ����ļ���
    	 * ����ֵΪfile[]
    	 * listfiles(FileFilter filter)
    	 * FileFilter:�ļ��������Ľӿ�
    	 * �鿴��ǰfile����·�������е��ļ����ļ���
    	 * ����ֵΪ�����ļ����������˺��File[]
    	 */
    	//.��ʾ��ǰ��Ŀ
    	File file4=new File(".");
    	File[] fsArr=file4.listFiles();
    	for (File fs : fsArr) {
    		if(fs.getName().endsWith(".txt")) {
    			System.out.println(fs.getName());
    		}
		}
    	//�ļ�������
    	FileFilterImple ft=new FileFilterImple();
    	File[] fsArr1=file4.listFiles(ft);
    	for (File fs1 : fsArr1) {
    		if(fs1.getName().endsWith(".txt")) {
    			System.out.println(fs1.getName());
    		}
		}
    }
	public static void test01(String path) throws Throwable {
		File file5=new File(path);
		File parent=file5.getParentFile();
		if(!parent.exists()) {//�༶�ļ����Ƿ����
			parent.mkdirs();
		}
		//�����༶�ļ����µ��ļ��Ƿ����
		if(!file5.exists()) {
			file5.createNewFile();
		}
	}

	/*
	 * 1-100�������ֵĺ�
	 * ������ʹ��for,while,do-while...
	 * 
	 * �ݹ�:
	 * 1.����ÿ�����
	 * 2.���ǵ��������
	 * 3.�������ڲ������ظ��Ĳ���(�Լ������Լ�)
	 */
	public static int sum(int num) {
		if(num==1) {
			return 1;
		}else {
			return num+sum(num-1);
		}
	}
	/*
	 * ɾ���༶�ļ���---�ݹ�
	 * --���ļ��в�������ɾ��
	 * 
	 * ɾ���ļ���ɾ�����ļ���delete()
	 * 
	 * ��ȡ���ļ��������е����ļ�/�ļ���
	 * ��������ļ�--ɾ��
	 * ��������ļ���--��ȡ���ļ��µ��ļ�/�ļ���
	 */
	public static void deleteFile(File path) {
		if(path.isDirectory()) {
			File[] fsArr=path.listFiles();
			for (File file : fsArr) {
				deleteFile(file);
			}
		}
		path.delete();
	}	
	
    public static void main(String[] args) throws Throwable {
//    	test01("demo\\a\\b\\c\\1.txt");
//    	System.out.println(sum(100));
    	File file=new File("demo");
    	deleteFile(file);
	}
}
//�ļ���������ʵ����
class FileFilterImple implements FileFilter{
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith("txt");
	}


}










