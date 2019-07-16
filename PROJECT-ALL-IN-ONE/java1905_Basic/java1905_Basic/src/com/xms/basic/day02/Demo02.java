package com.xms.basic.day02;
/**
 * 演示八种基本数据类型
 * 		数据类型：
 * 			1.基本数据类型：只有八种
 * 			2.引用数据类型：无数种
 * 		整数类型：byte（二进制）,short,int（常用）,long（长整）表示整数
 * 		浮点类型：float（单精度），double（双精度）
 * 		字符类型：char  存储字符    表示单引号表示字符---字符编码
 * 		布尔类型：boolean  只存储两个值：true,false
 * @author Administrator
 *
 */
public class Demo02 {
	//程序入口
	public static void main(String[] args) {
		/**
		 * 包装类：只是针对八种基本数据类型
		 * 				 每种基本数据类型都有对应的包装类
		 * 				
		 * 八种基本数据类型的包装类：除了int--Integer,char--Character这两个
		 * 												比较特殊，其余包装类都是原单词首字母大写
		 * 
		 * byte---Byte
		 * .....
		 * .....
		 * 
		 * 
		 *可以使用包装类获取对基本类型的最大值和最小值（范围）--boolean除外
		 * 语法：包装类.MAX_VALUE  最大值
		 * 语法：包装类.MIN_VALUE	 最小值
		 */
		/*
		 * 整数类型:java中整数类型默认的字面量为int类型，
		 * 				一旦超出int类型范围就会编译报错
		 * 
		 * 字面量:可以直接看到具体的数据值
		 * 
		 */
		byte a=12;//字节---数据类型的最小单元
		short b=13;
		int c=14;
		long d=15;
		long id=340406199908062418l;//  l/L表示为long类型的数据
		//jdk封装一个方法：获取系统当前时间距离1970/1/1 00：00：00的毫秒数
		//1秒=1000毫秒
		long time=System.currentTimeMillis();
		System.out.println("当前系统时间:"+time);
		//获byte类型的最大值/最小值
		byte byteMax=Byte.MAX_VALUE;	
		byte byteMin=Byte.MIN_VALUE;	
		System.out.println("byte的最大值："+byteMax);
		System.out.println("byte的最小值:"+byteMin);
		/*
		 * 浮点类型：java中浮点类型默认的字面量为double类型
		 * 
		 * 十进制无法准确表示1/3---会有舍入误差
		 * 二进制无法准确表示1/10---会有舍入误差
		 * double a=3.0;
		 * double b=2.9;
		 * a-b=0.10000000000000009---会有舍入误差
		 * 
		 * 如果想精确表示小数点后面的位数：BigDecimal类
		 */
		double a1=3.0;
		double b1=2.9;
		System.out.println(a1-b1);
		
		float e=12.5F;//f/F表示这是float类型的数据
		double f=12.5;//可以在字面量后面加上D/d表示double--可有可无
		
		/*
		 * 字符类型：事实上一个16位无符号的整数，这个值对应的叫做字符编码
		 * 		--字符类型：‘’单引号表示
		 * 		--java的字符采用是Unicode字符集编码，Unicode是世界通用的定长
		 * 			字符集，所有的字符0~16位进行表示
		 * 		--字符可以使用直接量表示：'中'，也可以使用字符编码：‘\u4e2d’
		 * 		--将字符存入内存中时是将字符编码放入
		 * 注意:
		 * 		单引号中有且只有一个字符
		 * 		每一个字符都对应一个int类型的数-----ASCII
		 * 		
		 * 对于某些字符不方便输出：转义字符
		 * 	'\n':表示回车
		 * 	'\r':表示换行
		 * 	'\\':表示\
		 * 	'\t':表示空格
		 * ...
		 * ...
		 * 		
		 * 
		 */
		char g='中';
		char g1='\u4e2d';
		/*
		 * 布尔类型：主要是用于逻辑关系的判断（事件的真假）
		 * 				事件为真：true表示
		 * 				事件为假：false表示
		 * 
		 */
		boolean h=true;
		boolean i=false;
		
		
	}

}























































