package com.xms.basic.day03.p;

import java.util.Scanner;

/***
 * （3）打印出联合国卫生组织对年龄的划分，并在控制台输出
	0到17岁为未成年人
	18到65岁为青年人
	66到79岁为中年人
	80到99岁为老年人
	100以上长寿老人
 * @author Administrator
 *
 */
public class Demo03 {
	public  static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入你的年龄：");
		int age=sc.nextInt();
		if(age>0&&age<=17) {
			System.out.println("未成年");
		}else if(age>=18&&age<=65) {
			System.out.println("青年");
		}else if(age>=65&&age<=79) {
			System.out.println("中年");
		}else if(age>=80&&age<=99) {
			System.out.println("老年");
		}else if(age>=100) {
			System.out.println("长寿");
		}
		
	}

}












































