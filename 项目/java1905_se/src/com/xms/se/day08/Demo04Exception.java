package com.xms.se.day08;
/**
 * finally:最终的
 * 	和try-catch一起使用
 * 	表示无论try块中代码是否异常,finally中的代码都会被执行
 * 
 * 	finally通常是做结尾的清理操作
 * 	关闭流,关闭数据库连接...
 * 	
 * @author deo
 *
 */
public class Demo04Exception {
	public static void main(String[] args) {
		try {
			System.out.println("加载驱动");
			System.out.println("与数据库建立连接");
			System.out.println("操作数据库中数据");
			System.out.println("处理数据");
			System.out.println("保存数据");
			
		} finally {
			System.out.println("关闭数据库连接");
		}
	}
}














