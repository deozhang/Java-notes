package com.xms.basic.day10.Demo04;
/**
 * 内部类:一个类可以定义在另外一个类中，外部的类
 * 				叫做外部类，内部的类叫做内部类
 * 
 * 				内部类定义在外部类，通常只服务于外部类，对外部的其他类是不可见
 * 				的，内部类可以调用外部的类成员变量和方法（包括私有的）
 * 
 * 匿名内部类：没有名字的内部类
 * 						如果在一段程序需要创建某一个类型的对象，而且只
 * 						创建这一个对象，该类就不再使用，此时该类可以不
 * 						用命名，需要使用匿名内部类
 * 						注意：该类需要需要继承某个类或者实现某个接口
 * 	一个文件中有几个class关键字，就会生成几个.class文件
 * 计算机也会给匿名内部类随机分配对应的类名（.class文件）
 * 
 * @author Administrator
 *
 */
public class Outer {//外部类
	//成员变量
	int a;
	private int b;
	
	//1.声明一个内部类类型的变量
	Inter i;
	
	public Outer() {
		i=new Inter();
	}
	
	//成员方法
	public void methodOuter() {
		System.out.println("methodOuter");
	}
	
	/*
	 * 2.工厂方法
	 */
	public Inter createInter() {
		return new Inter();
	}
	
	private  class Inter{//内部类
		 //成员变量
		int c=100;
		int d;
		//构造方法
		public Inter() {
			
		}
		//成员方法
		public void methodInter() {
			System.out.println("methodInter");
			/*
			 * 在调用外部类中成员变量和方法时，有隐式的指向
			 * 外部类型类型的引用：外部类型的类名.this
			 * ---写或者不写都有
			 */
			System.out.println(a);
			System.out.println(b);
			methodOuter();
		}
		
	}

}
