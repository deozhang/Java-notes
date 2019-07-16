package com.xms.basic.day10.Demo02;
/**
 * 接口：
 * 	java以面向对象为核心的计算机编程语言
 * ---以面向对象的为核心的面向接口编程
 * 
 * 类：封装数据---数据
 * 接口：封装对数据操作的方法---行为
 * 
 * 1.接口：就是一种标准，一种规范---制定标准
 * 		---关键字：interface表示接口
 * 2.接口中包含常量，抽象方法，静态方法，default方法---jdk1.8
 * 	   接口中包含常量，抽象方法---jdk1.6
 * 3.接口不能实例化,需要普通类实现，实现接口类称为实现类
 * 		用implements表示实现关系(类名imple:表示实现类),
 * 		如果实现类既需要继承，又需要实现，原则：先继承再实现
 * 		1.接口的实现--支持多实现，各个接口之间用逗号隔开
 * 		2.接口与接口之间支持多继承
 * 4.实现类需要实现接口中所有的抽象方法
 * 5.接口实现方法的权限修饰符要等于接口中方法的权限修饰符
 * 
 * 接口和抽象类的区别:
 * 		1.内容组成：
 * 				抽象类：
 * 						1.成员变量
 * 						2.构造方法
 * 						3.可以有普通（static）方法和抽象方法
 * 				接口：
 * 						1.有常量
 * 						2.没有构造方法
 * 						3.有抽象方法，静态方法，default方法
 * 	
 * 		2.类型关系：
 * 				类与类，类与接口，接口与接口
 * 		3.相同点：
 * 				都不能被实例化，需要多态进行实现实例化
 * 
 * 
 * 编辑器：
 * 			父类类型大于子类类型---extends
 * 			接口大于实现类---implements
 * 
 * 
 * @author Administrator
 *
 */


public interface Inter {
	//常量
	public static final int NUM=10;
	int NUM1=10;//public static final
	final int NUM2=10; //public static 
	
	//抽象方法
	public abstract void add1();
	void add2();//public abstract 
	
	//静态方法
	public static void add3() {
		System.out.println("静态方法");
	}
	
	//default方法---default只能在接口中修饰方法
	default void add4() {
		System.out.println("defualt-add4()");
	}
	
//	public void show() {
//		System.out.println("show");
//	}
	
}



































