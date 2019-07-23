package com.xms.basic.day04.p;

import java.util.Scanner;

/**
 * 
11.计算a+aa+aaa+aaaa+...的值
a的值和计算多少位从控制台输入
要求在控制显示如下
 s=1+11+111+1111+..=?
 * @author Administrator
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入数字：");
		int a=sc.nextInt();
		System.out.println("请输入数字的位数：");
		int b=sc.nextInt();
		/**
		 * 1.计算整体数字的值  1+11+111=?
		 * 2.使用字符串拼接，成最终效果
		 */
		int sum=0;//所有数字的结果
		int h=a;//每一位数字的值
		int t=a;
		for(int i=1;i<=b;i++) {
			/**
			 * sum      		h        			a
			 * 1					11				10
			 * 1+11			100+11		100
			 * 1+11+111	1000+111	1000
			 */
			sum=sum+h;
			//为下一次的数字做铺垫
			h=a*10+h;
			a=a*10;
			
		}
		System.out.print("sum=");
		//2.使用字符串拼接
		for(int i=1;i<=b;i++) {//行
			//行内容
			for(int j=1;j<=i;j++) {//列
				//列的内容
				System.out.print(t);
			}
			if(i!=b) {
				System.out.print("+");
			}
		}
		System.out.print("="+sum);
		
		 
		
	}

}










































































