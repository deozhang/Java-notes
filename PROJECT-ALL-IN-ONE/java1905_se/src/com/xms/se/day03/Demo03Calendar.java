package com.xms.se.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * 日历类：java.util.Calendar
 * 因为Date类操作时间分量不方便，所以引入日历类
 * 该类是一个抽象类，其中的方法可以对时间分量进行一一设置
 * 
 * 注意：日历类中
 * 			月份：月份是从0开始		1~12月的数字分别为：0~11；
 * 			周：周日为一周的开始    周日~周六的数字分别为1-7；
 * 
 * 		
 * @author Administrator
 *
 */
public class Demo03Calendar {
	public static void method1() {
		//创建日历类对象
		Calendar cal=Calendar.getInstance();
		System.out.println(cal);
		
		/*
		 * get(int field):
		 * 获取日历类对象时间分量的值
		 * 返回值为对应时间分量
		 */
		int year=cal.get(Calendar.YEAR);
		System.out.println("年："+year);
		int month=cal.get(Calendar.MONTH);
		int day1=cal.get(Calendar.DAY_OF_MONTH);
		int day2=cal.get(Calendar.DATE);
		int hour1=cal.get(Calendar.HOUR);
		int hour2=cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("月："+month);
		System.out.println("日："+day1);
		System.out.println("日："+day2);
		System.out.println("十二小时："+hour1);
		System.out.println("二十四小时："+hour2);
		
		System.out.println("-----------------------------------");
		/*
		 * set(int field,int value):
		 * --1.field：指定的时间分量
		 * --2.value:要赋给的值
		 * 给指定的时间分量设定指定值
		 * 
		 */
		cal.set(Calendar.YEAR,2049);
		System.out.println(cal.get(Calendar.YEAR));
		cal.set(Calendar.MONTH,Calendar. OCTOBER);//最好写英文常量以防混乱
		cal.set(Calendar.DATE,24);
		cal.set(Calendar.DAY_OF_MONTH, 26);
		cal.set(Calendar.HOUR,23);
		System.out.println(cal.get(Calendar.HOUR));
		/*
		 * 一年的某一天:DAY_OF_YEAR
		 * 一周的某一天:DAY_OF_WEEK
		 * 一个月的某一天：DAY_OF_MONTH    /DATE
		 */
		
	}
	
	public static void method2() {
		/*
		 * 计算系统当前时间，在十天后的今天是几号？
		 */
		Calendar cal=Calendar.getInstance();
		int day=cal.get(Calendar.DAY_OF_YEAR)+25;
		cal.set(Calendar.DAY_OF_YEAR,day);
		System.out.println(cal.get(Calendar.DATE));
		
		int day1=cal.get(Calendar.DAY_OF_MONTH)+10;
		cal.set(Calendar.DAY_OF_MONTH,day1);
		System.out.println(cal.get(Calendar.DATE));
		//用day_of_month 与day_of_year效果是一样的 不用担心超出到第二个月
		
		/*
		 * add(int field,int value):
		 * 直接在对应的时间分量上计算值
		 * 加：正数    减：负数
		 * 一样不需要关心时间超出的情况
		 */
		cal.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
	}
	
	public static void method3() {
		/*
		 * setTime(Date date):
		 * --将给定的Date类型数据，转成日历类数据
		 * --void
		 * 
		 * getTime():
		 * --将当前日历类数据转成日期类数据
		 * --返回值为Date类型数据
		 * 
		 * 计算系统当前时间，在十个月，十天后，当周的周三是什么日期
		 * 输出的格式如下“yyyy/MM/dd”
		 * 
		 */
		Calendar cal=Calendar.getInstance();
		//十个月后
		cal.add(Calendar.MONTH, 10);
		//十天后
		cal.add(Calendar.DAY_OF_MONTH, 10);
		//设置为周三
		cal.set(Calendar.DAY_OF_WEEK, 4);
		Date date=cal.getTime();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		String str=sdf.format(date);
		System.out.println(str);
		
	}
	
	public static void method4() throws Throwable {
		/*
		 * 输入一个时间，计算该时间在三月，三天后当周的周三是什么日期
		 * 输出效果：“yyyy/MM/dd"
		 */
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		System.out.println("请按照yyyy/MM/dd 格式输入一个日期：");
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
//		String str="2049/03/06";
		Date date=sdf.parse(str);
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 3);
		cal.add(Calendar.DAY_OF_MONTH, 3);
		cal.set(Calendar.DAY_OF_WEEK,4);
		date=cal.getTime();
		str=sdf.format(date);
		System.out.println(str);
		
		sc.close();
	}
	
	public static void method5() throws Throwable {
		/**
		 * 计算商品的促销日期：
		 * 		效果：输出一个商品的生产日期，保质期，保质期前几天促销
		 * 				输出：促销日期
		 * eg：输入：
		 * 生产日期：2019/07/01
		 * 保质期：30
		 * 保质期：10
		 * 
		 * 输出：2019/07/21
		 */
		Scanner sc=new Scanner(System.in);
		System.out.println("请按yyyy/MM/dd 的格式输入生产日期：");
		String dates=sc.nextLine();
		System.out.println("请再输入保质期时长");
		int days=sc.nextInt();
//		String dates="2019/07/01";
//		int days=30;
		System.out.println("生产日期为："+dates);
		System.out.println("保质期时长为："+days+"天");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Calendar cal=Calendar.getInstance();
		Date date=sdf.parse(dates);
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, days*2/3);
		date=cal.getTime();
//		long ms=date.getTime()+days*2/3*24*60*60*1000;
//		date=new Date(ms);
		dates=sdf.format(date);
		
		System.out.println("建议促销时间为："+dates);
		
		
	}
	public static void main(String args[]) throws Throwable {
//		method1();
//		method2();
//		method3();
//		method4();
		method5();
	}
	
}
