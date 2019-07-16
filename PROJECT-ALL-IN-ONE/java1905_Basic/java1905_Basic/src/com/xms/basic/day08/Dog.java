package com.xms.basic.day08;
/**
 * 狗类
 * @author Administrator
 *
 */
public class Dog extends Animal  {
	//成员变量
	int noseColor;//鼻子的颜色--狗类特有的属性
	
	public Dog() {
		/*
		 * 只能写在父类构造方法的第一行
		 */
		super();
		
	}
	
	public Dog(String name) {
		super();
		this.name=name;
	}
	
	public Dog(String name,int age,int noseColor) {
//		super();
//		this.name=name;
		this(name);
		this.age=age;
		this.noseColor=noseColor;
		
	}
	public Dog(String name,int age,char sex,int noseColor) {
//		super();//调用父类中的无参数的构造方法
		super(name,age,sex);//调用父类中的有参数的构造方法
//		this.name=name;
//		this.age=age;
//		this.sex=sex;
		this.noseColor=noseColor;
		System.out.println("Dog");
		
	}
	
	public void play() {
		System.out.println(this.name);//父类
		System.out.println(this.noseColor);//本类
		
		System.out.println(super.name);//父类
//		System.out.println(super.noseColor);//报错
	}
	
	
	
	public void method1() {
		this.play();//本类
		this.work();//父类
		
		super.work();//父类
		
	}
	
	public void work() {
		System.out.println("看家");
	}
//	private void work1() {
//		System.out.println("看家1");
//	}
	
//	private void eat() {
//		System.out.println("吃饭");
//	}

	//子类重写静态方法
	public static  void add() {
		System.out.println("son--add");
	}
	
	
	
	
	
	
	
	
	

}
