package com.xms.basic.day08;
/**
 * 测试类
 * @author Administrator
 *
 */
public class TestTeacher {
	public static void main(String[] args) {
		//创建老师类对象---实例化（调用该类中的无参数的构造方法创建对象）
		Teacher t=new Teacher();
		//赋值
		t.name="张三";
		//取值
		String name1=t.name;
		System.out.println(name1);
		System.out.println(t.age);
		//调用成员方法
		t.teach();
		System.out.println("///////////////////////////////////////////////////////");
		//调用有参数的构造方法
		Teacher t1=new Teacher("zs",18);
		System.out.println(t1.name);
		System.out.println(t1.age);
		System.out.println(t1.money);
		
		System.out.println("//////////////////////////////////////////////");
		Teacher t2=new Teacher("zs", 18, '男', 5);
//		Teacher t3=new Teacher("zs"）;
//		System.gc();
		
	}
	

}
