package com.xms.basic.day07.p;
/**
 * 测试类
 * @author Administrator
 *
 */
public class TestTeacher {
	public static void main(String[] args) {
		//创建对象(实例化)--老师对象
		Teacher t=new Teacher();
		//成员变量赋值
		t.name="李四";
		t.age=25;
		t.sex='男';
		//取值
		String name1=t.name;
		System.out.println("name1="+name1);
		double money1=t.money;
		System.out.println("money1="+money1);
		//调用成员方法
		t.teach();
		t.playGame();
		
		
	}

}



















