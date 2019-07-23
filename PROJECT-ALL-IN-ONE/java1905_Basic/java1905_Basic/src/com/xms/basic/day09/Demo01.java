package com.xms.basic.day09;
import java.util.Date;
//import java.util.Random;//声明引入的类  ---   包名.类名（导包）
//import java.util.Scanner;
import java.util.*;//jsp中经常使用


/**
 * 包：定义类的时候需要定义类的名称，但是如果仅仅将类名作为类的
 * 		唯一标识符，则会出现命名冲突的情况，这会给类（组件）的使用
 * 		造成麻烦
 * 作用：方便管理类
 * 关键字:package
 * 
 * 
 * 声明所引入的类：
 * 		---import：
 * 			语法：import 包名.类名
 * 
 * 	
 * 通配符：*   
 * 			在对应包中寻找与程序中类名相同的类引入
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Random rd=new Random();
		Scanner sc=new Scanner(System.in);
		
		
		Date date=new Date();
		java.sql.Date date1=new java.sql.Date(123);
	}

}
































