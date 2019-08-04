package com.xms.se.day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//活了多少天
public class Birthday {
	public static void main(String args[]) throws Throwable {
		Scanner sc=new Scanner(System.in);
		System.out.println("请以yyyy/MM/dd HH:mm:ss 格式输入你的生日：");
		String birth=sc.nextLine();
//		String birth="1997/04/18 00:00:00";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dBirth=sdf.parse(birth);
		long time1=dBirth.getTime();
//		System.out.println(time1);
		Date now=new Date();
		long time2=now.getTime();
		long msday=time2-time1;
		
		String nows=sdf.format(now);
		System.out.println("现在是："+nows);
		long days=msday/1000/60/60/24;
		System.out.println("在这个世界上，你已经存在了"+days+"天");
		
		
	}
}
