package com.xms.basic.day03.p;

import java.util.Scanner;

/**
 * 分支练习
 * @author Administrator
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		 System.out.println("请输入一个int类型的数：");
		 int num=sc.nextInt();
		 if(num%3==0) {
			 System.out.println("能被3整除");
		 }else {
			 System.out.println("不能被3整除");
		 }
	}

}






























