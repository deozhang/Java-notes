package com.xms.basic.day03;
/**
 * 特殊的分支结构:
 * 		switch-case:根据switch中的值，与入口case的值进行等值比较，
 * 		如果两者相等，则从该入口进入，执行该case语句中的逻辑代码。
 * 		语法：
 * 			switch(整型/字符型/字符串){
 * 					case 常量值1：
 * 							逻辑语句1；
 * 					case 常量值2：
 * 							逻辑语句2；
 * 					case 常量值3：
 * 							逻辑语句3；
 * 					......
 * 					......
 * 					
 * 					default:
 * 							默认语句；
 * 
 * 
 * 			}
 * 		执行流程：根据switch中从case入口从上到下做等值判断，如果switch中的
 * 						值和某一个case入口相等，则从该入口进入执行且一直将整个switch-case
 * 						执行完毕；如果没有找到对应的入口，则执行默认的default语句
 * 	
 * 		switch-case:可以搭配break关键字使用，用于跳出switch-case结构
 * 		switch-case的优缺点:
 * 			1.优点：结构简单，清晰，使用方便
 * 			2.缺点：数据类型有限制，只能做等值判断
 * 
 * 		if和switch-case的区别：
 * 			1.两者都是分支结构，用于判断条件成立，执行某些语句
 * 			2.switch-case：在判断条件时，有数据类型的限制，且只能
 * 										做等值判断，不能做值域判断
 * 			3.if：可以判断任何类型的数据，既可以做等值判断，也可以做
 * 										值域判断
 * 				----所有的switch--case都可以使用if语句改写，但是switch-case
 * 					  只能改写if语句中的等值判断
 * 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class Demo05 {
	public static void main(String[] args) {
//		int key=5;
//		char key='b';
		String key="d";
		switch(key) {
			case "a":
				System.out.println("1");
				break;//强制操作--将switch-case打断
			case "b":
				System.out.println("2");
				break;
			case "c":
				System.out.println("3");
				break;
			default :
				System.out.println("默认语句");
				break;
		}
		
		
	} 

}












































