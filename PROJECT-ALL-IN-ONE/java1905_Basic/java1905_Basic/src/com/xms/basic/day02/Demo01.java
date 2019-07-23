package com.xms.basic.day02;
/**
 * 演示变量
 * @author Administrator
 *
 */
public class Demo01 {
	//程序入口（main方法）
	public static void main(String[] args) {
		//变量声明--开辟对应类型的存储空间 
		//1.变量的类型，变量名
		int age;//int age=12;
//		int class;
//		int a;//年龄
//		int A;
		int sg;//身高
		/*
		 * 变量的命名规则：
		 * 1.变量是数字，字母，下划线_,$组成
		 * 2.变量的首字符不能是数字
		 * 3.变量不能使用关键字（public class  int .......）
		 * 4.变量大小写敏感（a,A不同）
		 * 		----建议使用小写（不属于语法范畴）
		 * 5.行业内的规则：命名变量尽量做到见名知意（义）
		 * 
		 * 	变量的写法：
		 * 			1.单个单词的变量名---全部使用小写
		 * 				年龄--age
		 * 				姓名--name
		 * 			2.多个单词的变量名---“驼峰命名法”:除了第一个单词首字母小写
		 * 				其余单词首字母全部大写
		 * 				学生姓名：studentName
		 * 				学生班级：studentClass
		 * 				.......
		 * 				
		 * 		注意：
		 * 		1.变量的声明：使用一个特定的语法声明一个变量，让内存开辟其存储空间
		 * 		2.变量的命名：变量需要一个见名知意（义）的名字，且需要符合java语法定义
		 * 		3.变量的初始化：声明后，使用变量之前，必须给变量一个初始值
		 * 		4.变量的访问：	可以对变量进行存取操作，但是数据必须和变量的类型匹配		
		 * 
		 * 		分层次：
		 * 			1.守法：遵守语法
		 * 			2.道德：建议(不建议)
		 * 			3.和谐：移植性，健壮性，可维护性，复用性......
		 * 
		 */
		age=12;//变量的初始化  赋值
		System.out.println(age);
		String str="hello world";
		System.out.println(str);
		System.out.println("年龄："+age);
		
		
		
		
	}

}















































