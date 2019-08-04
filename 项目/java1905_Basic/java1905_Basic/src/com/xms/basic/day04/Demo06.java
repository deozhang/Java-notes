package com.xms.basic.day04;
/**
 * 循环结构：
 * 			for循环
 * 			语法：for(表达式1；表达式2；表达式3){
 * 							循环体
 * 						}
 * 			表达式1：循环的初始条件
 * 			表达式2：循环的判断条件---布尔类型表达式
 * 			表达式3：初始条件的变化量
 * 			执行流程：先给循环的初始条件初始化，再判断布尔类型表达式2，如果
 * 							布尔类型表达式结果为true,则执行循环体，然后执行表达式3
 * 							再判断布尔类型表达式2，循环往复，直到布尔类型表达式2为
 * 							false，循环结束
 * @author Administrator
 *
 */
public class Demo06 {
	public static void main(String[] args) {
		/*
		 * 输出1~10数字
		 */
		for(int i=1;i<=10;i++) {
			System.out.println(i);
		}
		System.out.println("剩余有效代码");
		System.out.println("------循环的写法-----------------------------------------------");
		//for循环的写法
		//1.死循环
//		for(int i=11;i<=10;i++) {
//			System.out.println(i);
//		}
//		for(;;) {
//			System.out.println("1");
//		}
		//2.for的多种样式
		/*
		 * 表达式1和表达式3可以放在小括号之外
		 */
//		int i=1;
//		for(;i<=10;) {
//			System.out.println(i);
//			i++;
//		}
		/*
		 * 表达式1和表达式3可以写多个，中间
		 * 使用都好隔开
		 * 注意：一般要求表达1的变量类型一致（自动类型转换除外）
		 */
		for(int i=1,j=1,k=1, m='a';i<=10;i++,j++,k++) {
			System.out.println(i);
		}
		
	}

}





































