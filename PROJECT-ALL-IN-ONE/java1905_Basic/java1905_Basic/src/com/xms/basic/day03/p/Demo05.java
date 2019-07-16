package com.xms.basic.day03.p;

import java.util.Scanner;

/**
 * 5.根据用于指定月份，打印该月份所属的季度
//3，4,5春季  6,7,8夏季  9,10,11秋季 12，1,2冬季
（分别使用||和&&运算符）
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入月份：（1~12）");
		int  month=sc.nextInt();
		if(month>=1&&month<=12) {//数据输入正确
			if(month>=3&&month<=5) {
				System.out.println("春");
			}else if(month>=6&&month<=8) {
				System.out.println("夏");
			}else if(month>=9&&month<=11) {
				System.out.println("秋");
			}else if(month==12||month==1||month==2) {
				System.out.println("冬");
			}
		}else {//数据输入有误
			System.out.println("数据输入不正确");
		}
	}

}

































