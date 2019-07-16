package com.xms.basic.day03.p;

import java.util.Scanner;

/**
 * 4.根据用户输入的数值不同，打印对应的星期//if和switch-case
 * @author Administrator
 *
 */
public class Demo04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字（1~7）：");
		int num=sc.nextInt();
		if(num>=1&&num<=7) {//数据输入正确的情况
			if(num==1) {
				System.out.println("周一");
			}else if(num==2) {
				System.out.println("周二");
			}else if(num==3) {
				System.out.println("周三");
			}else if(num==4) {
				System.out.println("周四");
			}else if(num==5) {
				System.out.println("周五");
			}else if(num==6) {
				System.out.println("周六");
			}else if(num==7) {
				System.out.println("周日");
			}
		}else {//数据输入不正确的情况
			System.out.println("数据输入有误");
		}
		
		System.out.println("-----switch-case-----------------------------------------");
		switch (num) {
		case 1:
			System.out.println("周一");
			break;
		case 2:
			System.out.println("周二");
			break;
		case 3:
			System.out.println("周三");
			break;
		case 4:
			System.out.println("周四");
			break;
		case 5:
			System.out.println("周五");
			break;
		case 6:
			System.out.println("周六");
			break;
		case 7:
			System.out.println("周日");
			break;
		default:
			System.out.println("数据输入有误");
			break;
		}
		
	}

}









































