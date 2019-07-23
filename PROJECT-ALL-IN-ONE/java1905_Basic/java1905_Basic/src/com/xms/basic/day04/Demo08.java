package com.xms.basic.day04;

import java.util.Random;

/**
 * 工具类：随机产生数字
 * @author Administrator
 *
 */
public class Demo08 {
	public static void main(String[] args) {
		int i=1;
		while(i<10) {
			
			
			System.out.println(i);
			i++;
			if(i==5) {
				
			continue;
			}
			
		}
		System.out.println(i);//6
		System.out.println(";;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;");
		for(int a=1;a<10;a++) {
			if(a==5) {
				
				System.out.println(a);//5
				continue;
			}
		}
	}

}


















