package com.xms.se.day06;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Demo01File {
    public static void method1() {
    	//创建file对象
    	File file1=new File("D:\\1");
    	File file2=new File("D:\\1.txt");
       /*
        * File.separator(常量)
        * 作用：忽略跨平台文件分隔符的差异性
        */
    	File file3=new File("D:"+File.separator+"1");
    }
    
    public static void method2() {
    	/*
    	 * 获取文件周边信息
    	 */
    	File file = new File("1.txt");
    	/*
    	 * getName():
    	 * 1.获取当前文件、文件夹
    	 * 2.返回值为String类型
    	 */
    	String name=file.getName();
    	System.out.println("文件/文件夹："+name);
    	/*
    	 * exists()
    	 * 1.判断文件/文件夹是否存在
    	 * 2.返回值是布尔类型
    	 */
    	
    	/*
    	 * length()
    	 * 1.表示文件所占的字节数
    	 * 2.返回值为字节个数(long类型)
    	 * 3.文件夹是不占字节的
    	 */
    	
    	/*
    	 * canRead()
    	 * canWrite()
    	 * canExecute()
    	 * 
    	 */
    	
    	/*
    	 * lastModifiled()
    	 * 1.文件最后修改的时间
    	 * 2.返回值是修改时间距离1970/01/01的毫秒数
    	 */
    	long lon=file.lastModified();
    	System.out.println("lon:"+lon);
    }
    
    public static void method3() throws Throwable {
    	/*
    	 * isFile()/isDirectory
    	 * 1.判断当前file对象是否是文件/文件夹
    	 */
    	
    	/*
    	 * createNewFile()
    	 * 1.创建当前File路径下的文件
    	 * 2.返回值为布尔类型
    	 * 
    	 * delete()
    	 * 1.删除当前File路径下的文件/文件夹(文件夹为空时才允许被删除)
    	 * 2.返回值为布尔类型
    	 * 
    	 * 创建/删除文件/文件夹步骤,
    	 * 1.先判断是否存在
    	 * 2.再进行创建/删除
    	 */
    	File file=new File("test.txt");
    	if(!file.exists()) {
    		//创建文件
    		boolean bo=file.createNewFile();
    		System.out.println("bo:"+bo);
    	}
    	if(file.exists()) {
    		//删除文件
    		boolean bo1=file.delete();
    		System.out.println("bo1:"+bo1);
    	}
    	
    	/*
    	 * mkdir()创建单级文件夹
    	 * mkdirs()创建多级文件夹
    	 * 返回值为布尔类型
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
    	 * 删除单级文件夹
    	 */
    	if(file2.isDirectory()) {
    		boolean bo4=file2.delete();
    		System.out.println("bo4"+bo4);
    	}


    	/*
    	 * getParentFile()
    	 * 获取当前file对象文件/文件夹所在所有的上级路径
    	 * 返回值为file类型
    	 * getParent()
    	 * 获取当前file对象文件/文件夹所在所有的上级路径
    	 * 返回值为string类型
    	 * 
    	 * 写入的files路径是什么,就返回对应路径
    	 */
    	
    	/*
    	 * listFile()
    	 * 查看当前file对象路径下所有的文件和文件夹
    	 * 返回值为file[]
    	 * listfiles(FileFilter filter)
    	 * FileFilter:文件过滤器的接口
    	 * 查看当前file对象路径下所有的文件和文件夹
    	 * 返回值为按照文件过滤器过滤后的File[]
    	 */
    	//.表示当前项目
    	File file4=new File(".");
    	File[] fsArr=file4.listFiles();
    	for (File fs : fsArr) {
    		if(fs.getName().endsWith(".txt")) {
    			System.out.println(fs.getName());
    		}
		}
    	//文件过滤器
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
		if(!parent.exists()) {//多级文件夹是否存在
			parent.mkdirs();
		}
		//创建多级文件夹下的文件是否存在
		if(!file5.exists()) {
			file5.createNewFile();
		}
	}

	/*
	 * 1-100所有数字的和
	 * 不允许使用for,while,do-while...
	 * 
	 * 递归:
	 * 1.考虑每种情况
	 * 2.考虑到极限情况
	 * 3.当方法内部出现重复的操作(自己调用自己)
	 */
	public static int sum(int num) {
		if(num==1) {
			return 1;
		}else {
			return num+sum(num-1);
		}
	}
	/*
	 * 删除多级文件夹---递归
	 * --空文件夹才能允许被删除
	 * 
	 * 删除文件和删除空文件夹delete()
	 * 
	 * 获取该文件夹下所有的子文件/文件夹
	 * 如果是子文件--删除
	 * 如果是子文件夹--获取子文件下的文件/文件夹
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
//文件过滤器的实现类
class FileFilterImple implements FileFilter{
	@Override
	public boolean accept(File pathname) {
		return pathname.getName().endsWith("txt");
	}


}










