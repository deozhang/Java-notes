package com.xms.basic.day04;
/**
 * while和do-while的使用注意事项及区别：
 * 1.死循环
 * 2.和break关键字搭配--用于满足某些条件强制跳出当前循环
 * 3.while和do-while在执行循环时，判断条件第一次为false的
 * 		执行次数
 * 		while:一次都不会执行
 * 		do-while:至少执行一次
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
		/*
		 * 输出数字1~10
		 */
		int i=1;
		while(i<=10) {
			System.out.println(i);
			if(i==5) {
				break;
			}
			i++;
		}
		System.out.println("剩余有效代码");
	}

}


























