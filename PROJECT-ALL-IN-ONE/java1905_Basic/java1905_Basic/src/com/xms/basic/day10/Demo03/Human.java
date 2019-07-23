package com.xms.basic.day10.Demo03;
/**
 * 多态总结:
 * 	1.一种类型的引用，在指向不同对象时有不同的实现
 * 		   cut()----功能
 * 			1.厨师---cut():切菜
 * 			2.医生---cut():手术
 * 			3.理发师---cut():剪发
 * 			1.2.3都是人类
 * 
 * 
 * 2.同一（类型）对象，造型成不同类型时有不同的功能
 * 				我---Me---多态
 * 				1.老师----授课---teach()
 * 				2.警察----维护治安--protect()
 * 				3.父亲----教育孩子--play()
 * 
 * 				我是一个对象（Me），处在不同环境中，有不同功能
 * 	
 * @author Administrator
 *
 */
public abstract class Human {//抽象类
	public abstract void cut();
}

















