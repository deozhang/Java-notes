package com.xms.basic.day08;
/**
 * 老师类
 * 
 * 构造方法：创建对象，初始化成员变量的方法---支持方法的重载
 * 		--不同于普通方法，但是也是方法，即支持方法的重载
 * 			1.方法名必须和类名相同
 * 			2.没有返回值，但是也不能写void
 * 			语法：
 * 					权限修饰符  类名(){
 * 						........
 * 					}
 * 
 * 
 * this:----表示指代当前对象的引用
 * 			----在构造方法中，可以调用
 * 				  该类中已经存在的其他的构造方法
 * 			----区分构造方法中形式参数和成员变量
 * 
 * 
 * 变量：
 * 		1.根据存储位置：局部变量和成员变量
 * 			--1.局部变量:
 * 						1.定义在方法中（方法在类中定义）
 * 						2.没有初始值，使用之前必须初始化
 * 						3.方法调用时，存储在栈帧中，方法调用结束，栈帧	
 * 							消失，局部变量失效
 * 			--2.成员变量：		
 * 						1.定义在类中，方法外	
 * 						2.有默认值，使用之前，可以不用初始化
 * 						3.实例化对象后，存储在堆中，对象消失（gc回收），
 * 							成员变量失效	
 * 						gc()---垃圾回收的方法（守护线程（后台线程））
 * 						
 * 
 * 		2.根据数据类型：基本类型变量和引用类型变量
 * 						基本类型变量：八种数据类型声明变量
 * 						引用类型变量：除了八种基本数据类型变量之外的类型
 * 												声明的变量
 * 
 * 内存管理：
 * 		1.栈区:局部变量，创建对象时的引用变量（地址值），以及调用方法
 * 					时的参数值
 * 		2.堆区：创建的对象，成员变量
 * 		3.方法区：类的信息，以及方法（静态变量）
 * 
 * @author Administrator
 *
 */
public class Teacher {
	//成员变量
	String name;
	int age;
	char sex;
	double money;
	/*
	 * 如果一个类中没有写任何的构造方法，则编辑器会
	 * 自动追加一个无参数的构造方法，一旦写入构造方
	 * 法，编辑器则不会再默认追无参数的构造方法
	 * 
	 * ---即使不用无参数的构造方法，最好手动加入，防止后期
	 * 		编译报错
	 */
	//无参数的构造方法
	public Teacher() {
	
		System.out.println("无参数的构造方法");
	}
	
	//有参数的构造方法
	public Teacher(String name,int age) {
		this.name=name;
		this.age=age;
		
	}
	//有参数的构造方法
	public Teacher(String name,int age,char sex) {
		this.name=name;
		this.age=age;
		this.sex=sex;
		System.out.println("name，age,sex");
		
	}
	//有参数的构造方法
	public Teacher(String name,int age,char sex,double money) {
		//调用该类中三个参数的构造方法
		//必须得写在构造方法的第一行
		this(name,age,sex);
//		this.name=name;
//		this.age=age;
//		this.sex=sex;
//		this(money);//编译报错
		this.money=money;
		System.out.println("name,age,sex,money");
	}
	
	public Teacher(double money) {
		this.money=money;
	}
	
	//成员方法
	public void teach() {
		System.out.println("上课");
//		System.out.println(a);
	}
	
	public void run() {
		int a=10;
		System.out.println(a);
		System.out.println("运动");
	}
	public static void main(String[] args) {
		Teacher t=new Teacher();
		t.run();
		t.teach();
	}
	
	

}
























