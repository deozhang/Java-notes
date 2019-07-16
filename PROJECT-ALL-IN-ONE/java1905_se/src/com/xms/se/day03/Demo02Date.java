package com.xms.se.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Java中表示时间使用java.util.Date
 * 是用距离一个固定的时间点的毫秒数表示
 * 一个特定的时间
 * 
 * Java.util.Date类封装了日期及时间的信息
 * 该类的关于时间的计算方法已经被日历类替代。
 * 该类已经重写了toString方法
 * 
 * @author Administrator
 *
 */
public class Demo02Date {
	public static void main(String args[]) throws Throwable {
		//创建日期类对象
		Date date=new Date();
		/*
		 * 系统当前时间距离1970/01/01 00:00:00:000
		 * 的毫秒数
		 * 使用Date对象.getTime()获取距离时间原点的毫秒数  返回值为long类型
		 * 
		 */
		System.out.println(date);
		long time=date.getTime();
		System.out.println(time);
		
		/**
		 * 时间格式化类
		 * new SimpleDateFormat():
		 * --以系统默认的模式来构造转换日期和文本
		 * new SimpleDateFormat(String str):
		 * --以指定的模式来构造转换日期和文本   
		 * Date本身展示时间的形式不够友好，所以引入SimDateFormat类来将时间更好的展示
		 * 
		 * 
		 * java.text.SimpleDateFormat是以语言环境有关的方法，
		 * 来格式和解析的类
		 * 
		 * 		格式：日期--->文本（字符串）
		 * 			format(Date date):
		 * 			将日期类对象以某种格式转成字符串
		 * 			返回值为字符串类型
		 * 
		 *	 	解析：文本（字符串）--->日期
		 * 			parse(String str):
		 * 			将某种格式的字符串转成日期类
		 * 			返回值为日期类对象
		 * 
		 * 注意：需要指定模式需要和转换数据的模式一样（一般出现于 字符串转日期）
		 * 		字符串转日期，字符串中不要出现中文
		 * 
		 * 否则会出现：java.text.ParseException:转换异常
		 * 
		 * 
		 */
		
		//展示格式：2019/07/01 11:02:00
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//将日期类转换为指定格式的字符串
		String strTime=sdf.format(date);
		System.out.println(strTime);
		
		//将某种格式的字符串转换为日期类
		//2018/08/08 12:12:12
		String str="2018/08/08 12:12:12";
		Date date1=sdf.parse(str);
		
		date.clone();
	}
	/**
	 * 输出自己的生日，计算字从出生到现在一共活了几天？
	 * 思路：
	 * 输入的是字符串 转换为日期类计算 
	 */
	
	
}
